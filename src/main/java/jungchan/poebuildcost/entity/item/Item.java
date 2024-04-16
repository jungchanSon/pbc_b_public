package jungchan.poebuildcost.entity.item;

import com.google.gson.Gson;
import jungchan.poebuildcost.entity.Stats.AllStats;
import jungchan.poebuildcost.entity.Stats.Entry;
import jungchan.poebuildcost.entity.Stats.OptionType;
import jungchan.poebuildcost.entity.Stats.Result;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class Item {
    int id;
    Rarity rarity;
    String name;
    String baseName;
    String uniqueId;
    String radius;
    ItemType itemType;

    int itemLevel;
    int quality;
    int levelReq;
    int implicits;
    int allRes;

    public ArrayList<String> implicitOpts = new ArrayList<>();
    public ArrayList<String> options = new ArrayList<>();
    public ArrayList<String> optionsById = new ArrayList<>();
    public ArrayList<List<Integer>> optionsByValue = new ArrayList<>();

    public static Item createItem(ItemType itemType, String content) {

        String stripedContent = content.strip();
        String[] splitContent = stripedContent.split("\n");
        Item item = new Item();
        int i = 4;
        int implicitCnt = 0;
        item.setItemType(itemType);
        item.setRarity(Rarity.valueOf(splitContent[0].split(": ")[1]));
        item.setName(splitContent[1]);
        item.setAllRes(0);
        if (splitContent[2].contains("Unique ID:")) {
            item.setUniqueId(splitContent[2].split(": ")[1]);
        } else {
            item.setBaseName(splitContent[2]);
            for (String s: splitContent) {
                if (s.contains("Unique ID:")) {
                    item.setUniqueId(s.split(": ")[1]);
                    break;
                }
            }
        }
        if(item.getItemType() == ItemType.Weapon ){
            if(item.getBaseName().contains("Shield") || item.getBaseName().contains("Buckler")){
                item.setItemType(ItemType.Shield);
            } else if (item.getBaseName().contains("Quiver")) {
                item.setItemType(ItemType.Quiver);
            }
        }

        for(; i < splitContent.length; i++) {
            if (splitContent[i].contains("Item Level:")) {
                String il = splitContent[i].split(": ")[1];
                item.setItemLevel(Integer.parseInt(il));

            } else if (splitContent[i].contains("LevelReq:")) {
                String lr = splitContent[i].split(": ")[1];
                item.setLevelReq(Integer.parseInt(lr));

            } else if (splitContent[i].contains("Implicits:")) {
                String imp = splitContent[i].split(": ")[1];
                item.setImplicits(Integer.parseInt(imp));
                implicitCnt = Integer.parseInt(imp);
            } else if (splitContent[i].contains("Radius:")) {
                String r = splitContent[i].split(": ")[1];
                item.setRadius(r);

            }else if (splitContent[i].contains("Quality:") |
                splitContent[i].contains("Evasion:") |
                splitContent[i].contains("EvasionBasePercentile:")|
                splitContent[i].contains("Armour:")|
                splitContent[i].contains("ArmourBasePercentile:")|
                splitContent[i].contains("Sockets:")|
                splitContent[i].contains("Energy Shield:")|
                splitContent[i].contains("EnergyShieldBasePercentile:")|
                splitContent[i].contains("Unique ID:")) {
            }else {
                String optionId;
                item.options.add(splitContent[i]);
                String replace = splitContent[i].replace("{crafted}", "");
                String replace1 = replace.replace("{fractured}", "");
                String hashedOption = replaceNumbersWithHash(replace1);
                List<Integer> optionValues = extractNumbers(splitContent[i]);

                if(implicitCnt > 0) {
                    if (splitContent[i].contains("{crafted}")){
                        String replacedOption = splitContent[i].replace("{crafted}", "");
                        optionId = getOptionId(hashedOption, replacedOption, OptionType.Enchant, item.getItemType());
                    } else {
                        optionId = getOptionId(hashedOption, splitContent[i], OptionType.Implicit, item.getItemType());
                    }
                    implicitCnt--;

                } else {
                    String replacedContent = splitContent[i].replace("{fractured}", "");

                    optionId = getOptionId(hashedOption, replacedContent, OptionType.Explicit, item.getItemType());
                }
                item.optionsById.add(optionId);
                item.optionsByValue.add(optionValues);
                if (optionId != null && isResistanceOption(optionId)){
                    item.setAllRes(item.getAllRes() + optionValues.get(0));
                }
            }
        }
        return item;
    }

    private static boolean isResistanceOption(String optionId) {
        String FIRE       = "explicit.stat_3372524247";
        String COLD       = "explicit.stat_4220027924";
        String LIGHTNING  = "explicit.stat_1671376347";


        if (optionId.equals(FIRE)
            || optionId.equals(COLD)
            || optionId.equals(LIGHTNING)) {
            return true;
        } else {
            return false;
        }
    }

    private static String getOptionId(String hashedOption, String option, OptionType optionType, ItemType type) {

        String optionId = null;
        ClassPathResource classPathResource = new ClassPathResource("AllStats.json");
        Gson gson = new Gson();
        ArrayList<Result> result;
        String negativeHashedOption = "";
        String negativeOption = "";
        if(hashedOption.contains("reduced") | option.contains("reduced")) {
            negativeHashedOption = hashedOption.replace("reduced", "increased");
            negativeOption = option.replace("reduced", "increased");
        } else if (hashedOption.contains("increased") | option.contains("increased")) {
            negativeHashedOption = hashedOption.replace("increased", "reduced");
            negativeOption = option.replace("increased", "reduced");
        }

        String exceptionOpt = exceptionOptionCase(Pattern.compile(hashedOption), type);
        if (exceptionOpt != null) {
            return exceptionOpt;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
            AllStats o = gson.fromJson(bufferedReader, AllStats.class);
            result = o.getResult();
            for (Result r : result) {
                if (optionType.equals(OptionType.Explicit) && r.getId().equals("explicit")){
                    optionId = getOptionId(hashedOption, option, optionId, negativeHashedOption, negativeOption, r);
                } else if (optionType.equals(OptionType.Implicit) && r.getId().equals("implicit")) {
                    optionId = getOptionId(hashedOption, option, optionId, negativeHashedOption, negativeOption, r);
                } else if (optionType.equals(OptionType.Enchant) && r.getId().equals("enchant")){
                    optionId = getOptionId(hashedOption, option, optionId, negativeHashedOption, negativeOption, r);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return optionId;

    }

    private static String getOptionId(String hashedOption, String option, String optionId, String negativeHashedOption, String negativeOption, Result r) {
        ArrayList<Entry> entries = r.getEntries();
        for (Entry ent : entries) {
            String patternString = hashedOption;

            Pattern compile = Pattern.compile(patternString);
            Matcher matcher = compile.matcher(ent.getText());

            if (hashedOption.equals(ent.getText()) | option.equals(ent.getText())) {
                optionId = ent.getId();
            } else if (negativeHashedOption.equals(ent.getText()) | negativeOption.equals(ent.getText())) {
                optionId = ent.getId();
            } else if (matcher.find()==true) {
                optionId = ent.getId();
            }

        }
        return optionId;
    }

    private static String exceptionOptionCase(Pattern compile, ItemType type) {
        if (type == ItemType.Weapon) {
            if (compile.matcher("#% increased Attack Speed").find()) {
//              "#% increased Attack Speed (Local)";
                return "explicit.stat_210067635";
            } else if (compile.matcher("Adds # to # Physical Damage").find()) {
//                "Adds # to # Physical Damage (Local)";
                return "explicit.stat_1940865751";
            } else if (compile.matcher("Adds # to # Lightning Damage").find()) {
                return "explicit.stat_3336890334";
            } else if (compile.matcher("+# to Accuracy Rating").find()) {
                return "explicit.stat_691932474";
            } else if (compile.matcher("Adds # to # Fire Damage").find()) {
                return "explicit.stat_709508406";
            } else if (compile.matcher("Adds # to # Cold Damage").find()) {
                return "explicit.stat_1037193709";
            } else if (compile.matcher("#% chance to Poison on Hit").find()) {
                return "explicit.stat_3885634897";
            } else if (compile.matcher("#% of Physical Attack Damage Leeched as Life").find()) {
                return "explicit.stat_55876295";
            } else if (compile.matcher("#% of Physical Attack Damage Leeched as Mana").find()) {
                return "explicit.stat_669069897";
            } else if (compile.matcher("Adds # to # Chaos Damage").find()) {
                return "explicit.stat_2223678961";
            } else if (compile.matcher("Adds # to # Chaos Damage").find()) {
                return "explicit.stat_2223678961";
            }
        } else if (type == ItemType.Helmet) {
            if (compile.matcher("+# to maximum Energy Shield").find()) {
//                return "+# to maximum Energy Shield (Local)";
                return "explicit.stat_4052037485";
            } else if (compile.matcher("#% increased Energy Shield").find()) {
//                return "#% increased Energy Shield (Local)";
                return "explicit.stat_4015621042";
            } else if (compile.matcher("#% increased Evasion Rating").find()) {
//                return "#% increased Evasion Rating (Local)";
                return "explicit.stat_124859000";
            } else if (compile.matcher("+# to Evasion Rating").find()) {
//                return "+# to Evasion Rating (Local)";
                return "explicit.stat_53045048";
            } else if (compile.matcher("#% increased Armour").find()) {
//                return "#% increased Armour (Local)";
                return "explicit.stat_1062208444";
            } else if (compile.matcher("#% increased Armour and Energy Shield").find()) {
//                return "#% increased Armour and Energy Shield (Local)";
                return "explicit.stat_3321629045";
            } else if (compile.matcher("#% increased Armour and Evasion").find()) {
//                return "#% increased Armour and Evasion (Local)";
                return "explicit.stat_2451402625";
            } else if (compile.matcher("+# to Armour").find()) {
//                return "+# to Armour (Local)";
                return "explicit.stat_3484657501";
            } else if (compile.matcher("#% increased Evasion and Energy Shield").find()) {
//                return "+# to Armour (Local)";
                return "explicit.stat_1999113824";
            } else if (compile.matcher("#% increased Armour, Evasion and Energy Shield").find()) {
                return "explicit.stat_3523867985";
            }
        } else if (type == ItemType.Body) {
            if (compile.matcher("+# to maximum Energy Shield").find()) {
//                return "+# to maximum Energy Shield (Local)";
                return "explicit.stat_4052037485";
            } else if (compile.matcher("#% increased Energy Shield").find()) {
//                return "#% increased Energy Shield (Local)";
                return "explicit.stat_4015621042";
            } else if (compile.matcher("#% increased Evasion Rating").find()) {
//                return "#% increased Evasion Rating (Local)";
                return "explicit.stat_124859000";
            } else if (compile.matcher("+# to Evasion Rating").find()) {
//                return "+# to Evasion Rating (Local)";
                return "explicit.stat_53045048";
            } else if (compile.matcher("#% increased Armour").find()) {
//                return "#% increased Armour (Local)";
                return "explicit.stat_1062208444";
            } else if (compile.matcher("#% increased Armour and Energy Shield").find()) {
//                return "#% increased Armour and Energy Shield (Local)";
                return "explicit.stat_3321629045";
            } else if (compile.matcher("#% increased Armour and Evasion").find()) {
//                return "#% increased Armour and Evasion (Local)";
                return "explicit.stat_2451402625";
            } else if (compile.matcher("+# to Armour").find()) {
//                return "+# to Armour (Local)";
                return "explicit.stat_3484657501";
            } else if (compile.matcher("#% increased Evasion and Energy Shield").find()) {
//                return "+# to Armour (Local)";
                return "explicit.stat_1999113824";
            } else if (compile.matcher("#% increased Armour, Evasion and Energy Shield").find()) {
                return "explicit.stat_3523867985";
            }
        } else if (type == ItemType.Glove) {
            if (compile.matcher("+# to maximum Energy Shield").find()) {
//                return "+# to maximum Energy Shield (Local)";
                return "explicit.stat_4052037485";
            } else if (compile.matcher("#% increased Energy Shield").find()) {
//                return "#% increased Energy Shield (Local)";
                return "explicit.stat_4015621042";
            } else if (compile.matcher("#% increased Evasion Rating").find()) {
//                return "#% increased Evasion Rating (Local)";
                return "explicit.stat_124859000";
            } else if (compile.matcher("+# to Evasion Rating").find()) {
//                return "+# to Evasion Rating (Local)";
                return "explicit.stat_53045048";
            } else if (compile.matcher("#% increased Armour").find()) {
//                return "#% increased Armour (Local)";
                return "explicit.stat_1062208444";
            } else if (compile.matcher("#% increased Armour and Energy Shield").find()) {
//                return "#% increased Armour and Energy Shield (Local)";
                return "explicit.stat_3321629045";
            } else if (compile.matcher("#% increased Armour and Evasion").find()) {
//                return "#% increased Armour and Evasion (Local)";
                return "explicit.stat_2451402625";
            } else if (compile.matcher("+# to Armour").find()) {
//                return "+# to Armour (Local)";
                return "explicit.stat_3484657501";
            } else if (compile.matcher("#% increased Evasion and Energy Shield").find()) {
//                return "+# to Armour (Local)";
                return "explicit.stat_1999113824";
            } else if (compile.matcher("#% increased Armour, Evasion and Energy Shield").find()) {
                return "explicit.stat_3523867985";
            }
        } else if (type == ItemType.Boot) {
            if (compile.matcher("+# to maximum Energy Shield").find()) {
//                return "+# to maximum Energy Shield (Local)";
                return "explicit.stat_4052037485";
            } else if (compile.matcher("#% increased Energy Shield").find()) {
//                return "#% increased Energy Shield (Local)";
                return "explicit.stat_4015621042";
            } else if (compile.matcher("#% increased Evasion Rating").find()) {
//                return "#% increased Evasion Rating (Local)";
                return "explicit.stat_124859000";
            } else if (compile.matcher("+# to Evasion Rating").find()) {
//                return "+# to Evasion Rating (Local)";
                return "explicit.stat_53045048";
            } else if (compile.matcher("#% increased Armour").find()) {
//                return "#% increased Armour (Local)";
                return "explicit.stat_1062208444";
            } else if (compile.matcher("#% increased Armour and Energy Shield").find()) {
//                return "#% increased Armour and Energy Shield (Local)";
                return "explicit.stat_3321629045";
            } else if (compile.matcher("#% increased Armour and Evasion").find()) {
//                return "#% increased Armour and Evasion (Local)";
                return "explicit.stat_2451402625";
            } else if (compile.matcher("+# to Armour").find()) {
//                return "+# to Armour (Local)";
                return "explicit.stat_3484657501";
            } else if (compile.matcher("#% increased Evasion and Energy Shield").find()) {
//                return "+# to Armour (Local)";
                return "explicit.stat_1999113824";
            } else if (compile.matcher("#% increased Armour, Evasion and Energy Shield").find()) {
                return "explicit.stat_3523867985";
            }
        } else if (type == ItemType.Jewel) {
            if (compile.matcher("Adds # Small Passive Skill which grants nothing").find()) {
                return "explicit.stat_1085446536";
            }
        }

        return null;
    }

    private static String replaceNumbersWithHash(String input) {
        // 숫자를 찾기 위한 정규식 패턴
        if(input.contains("+")){
            input = input.replace("+", "\\+");
        }
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(input);

        // 찾은 모든 숫자를 #으로 대체
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, "([#\\\\d]+)");
        }
        matcher.appendTail(result);

        return "^"+ result +"$";
    }

    private static List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        // 숫자를 찾기 위한 정규식 패턴
        String regex = "\\b\\d+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // 찾은 모든 숫자를 리스트에 저장
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }

        return numbers;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", rarity=" + rarity +
                ", name='" + name + '\'' +
                ", baseName='" + baseName + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", radius='" + radius + '\'' +
                ", itemType=" + itemType +
                ", itemLevel=" + itemLevel +
                ", quality=" + quality +
                ", levelReq=" + levelReq +
                ", implicits=" + implicits +
                ", implicitOpts=" + implicitOpts +
                ", options=" + options +
                ", optionsById=" + optionsById +
                ", optionsByValue=" + optionsByValue +
                '}';
    }
}
