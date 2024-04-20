package jungchan.poebuildcost.service;

import jungchan.poebuildcost.entity.Stats.OptionType;
import jungchan.poebuildcost.entity.item.Item;
import jungchan.poebuildcost.entity.item.ItemType;
import jungchan.poebuildcost.entity.item.Rarity;
import jungchan.poebuildcost.repository.*;
import jungchan.poebuildcost.repository.MongoDocumentEntity.Enchant;
import jungchan.poebuildcost.repository.MongoDocumentEntity.Explicit;
import jungchan.poebuildcost.repository.MongoDocumentEntity.Implicit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class PobDocumentManager implements DocumentManager {

    private ThreadLocal<NodeList> itemsHolder = new ThreadLocal<>();

    private final ImplicitRepositoryWithTryCatch implicitRepository;
    private final ExplicitRepositoryWithTryCatch explicitRepository;
    private final EnchantRepositoryWithTryCatch enchantRepository;


    @Override
    public ArrayList<Item> parseItems(Document document) {
        itemsHolder.set(document.getElementsByTagName("Item"));

        Node sockets = document.getElementsByTagName("Sockets").item(0);
        Node itemSet = document.getElementsByTagName("ItemSet").item(0);

        ArrayList<Item> jewels = getJewels(sockets);
        ArrayList<Item> allItems = jewels;

        Item weapon1 = getEquipment(itemSet, "Weapon 1", ItemType.Weapon);
        Item weapon2 = getEquipment(itemSet, "Weapon 2", ItemType.Weapon);
        Item helmet = getEquipment(itemSet, "Helmet", ItemType.Helmet);
        Item bodyArmour = getEquipment(itemSet, "Body Armour", ItemType.Body);
        Item belt = getEquipment(itemSet, "Belt", ItemType.Belt);
        Item gloves = getEquipment(itemSet, "Gloves", ItemType.Glove);
        Item boots = getEquipment(itemSet, "Boots", ItemType.Boot);
        Item amulet = getEquipment(itemSet, "Amulet", ItemType.Amulet);
        Item ring1 = getEquipment(itemSet, "Ring 1", ItemType.Ring);
        Item ring2 = getEquipment(itemSet, "Ring 2", ItemType.Ring);
        Item flask1 = getEquipment(itemSet, "Flask 1", ItemType.Flask);
        Item flask2 = getEquipment(itemSet, "Flask 2", ItemType.Flask);
        Item flask3 = getEquipment(itemSet, "Flask 3", ItemType.Flask);
        Item flask4 = getEquipment(itemSet, "Flask 4", ItemType.Flask);
        Item flask5 = getEquipment(itemSet, "Flask 5", ItemType.Flask);
        itemsHolder.remove();

        allItems.add(weapon1);
        allItems.add(weapon2);
        allItems.add(helmet);
        allItems.add(bodyArmour);
        allItems.add(belt);
        allItems.add(gloves);
        allItems.add(boots);
        allItems.add(amulet);
        allItems.add(ring1);
        allItems.add(ring2);
        allItems.add(flask1);
        allItems.add(flask2);
        allItems.add(flask3);
        allItems.add(flask4);
        allItems.add(flask5);

        return allItems;
    }

    private Item getEquipment(Node itemSet, String type, ItemType itemType) {
        Node slot = itemSet.getFirstChild();

        while (slot != null) {
            if(slot.getAttributes().getNamedItem("name").getNodeValue().equals(type)){
                return createItemById(slot.getAttributes().getNamedItem("itemId").getNodeValue(), itemType);
            }
            slot = slot.getNextSibling();
        }

        return null;
    }

    private Item createItemById(String socketId, ItemType itemType) {
        NodeList items = itemsHolder.get();

        for (int i = 0; i < items.getLength(); i++) {
            Node item = items.item(i);
            String itemId = item.getAttributes().getNamedItem("id").getNodeValue();
            if (itemId.equals(socketId)) {
                String textContent = item.getTextContent();
//                Item equip = new Item(itemType, textContent, allOptionRepository);
                Item equip = createItem(itemType, textContent);

                return equip;
            }
        }

        return null;
    }

    private ArrayList<Item> getJewels(Node sockets) {

        Node socket = sockets.getFirstChild();
        ArrayList<String> socketIds = new ArrayList<>();

        while (socket != null){
            String socketId = socket.getAttributes().getNamedItem("itemId").getNodeValue();

            socketIds.add(socketId);

            socket = socket.getNextSibling();
        }
        ArrayList<Item> jewels = createJewelsById(socketIds);
        return jewels;
    }

    private ArrayList<Item> createJewelsById(ArrayList<String> socketIds) {
        NodeList items = itemsHolder.get();

        ArrayList<Item> jewels = new ArrayList<>();

        for (int i = 0; i < items.getLength(); i++) {
            Node item = items.item(i);
            String itemId = item.getAttributes().getNamedItem("id").getNodeValue();
            if (socketIds.contains(itemId)) {
                String textContent = item.getTextContent();
                Item jewel = createItem(ItemType.Jewel, textContent);
                jewels.add(jewel);
            }
        }

        return jewels;
    }

    private Item createItem(ItemType type, String textContent) {
        Item item = new Item();
        int implicitCnt = 0;
        item.setItemType(type);


        String[] contents = textContent.strip().split("\n");
        item.setRarity(Rarity.valueOf(contents[0].split(": ")[1]));
        item.setName(contents[1]);
        item.setAllRes(0);

        if (contents[2].contains("Unique ID:")) {
            item.setUniqueId(contents[2].split(": ")[1]);
        } else {
            item.setBaseName(contents[2]);
            for (String s : contents) {
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

        for(int i=4; i < contents.length; i++) {
            if (contents[i].contains("Item Level:")) {
                String il = contents[i].split(": ")[1];
                item.setItemLevel(Integer.parseInt(il));

            } else if (contents[i].contains("LevelReq:")) {
                String lr = contents[i].split(": ")[1];
                item.setLevelReq(Integer.parseInt(lr));

            } else if (contents[i].contains("Implicits:")) {
                String imp = contents[i].split(": ")[1];
                item.setImplicits(Integer.parseInt(imp));
                implicitCnt = Integer.parseInt(imp);
            } else if (contents[i].contains("Radius:")) {
                String r = contents[i].split(": ")[1];
                item.setRadius(r);

            } else if (contents[i].contains("Quality:") |
                    contents[i].contains("Evasion:") |
                    contents[i].contains("EvasionBasePercentile:")|
                    contents[i].contains("Armour:")|
                    contents[i].contains("ArmourBasePercentile:")|
                    contents[i].contains("Sockets:")|
                    contents[i].contains("Energy Shield:")|
                    contents[i].contains("EnergyShieldBasePercentile:")|
                    contents[i].contains("Unique ID:")) {
            } else {
                String optionId;
                item.options.add(contents[i]);
                String replace = contents[i].replace("{crafted}", "");
                String replace1 = replace.replace("{fractured}", "");
                String hashedOption = replaceNumbersWithHash(replace1);
                List<Integer> optionValues = extractNumbers(contents[i]);

                if(implicitCnt > 0) {
                    if (contents[i].contains("{crafted}")){
                        String replacedOption = contents[i].replace("{crafted}", "");
                        optionId = getOptionId(hashedOption, replacedOption, OptionType.Enchant, item.getItemType());
                    } else {
                        optionId = getOptionId(hashedOption, contents[i], OptionType.Implicit, item.getItemType());
                    }
                    implicitCnt--;

                } else {
                    String replacedContent = contents[i].replace("{fractured}", "");
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
    private boolean isResistanceOption(String optionId) {
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
    private String replaceNumbersWithHash(String input) {
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

    private List<Integer> extractNumbers(String input) {
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

    private String getOptionId(String hashedOption, String option, OptionType optionType, ItemType type) {
        String optionId = null;
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
        if (optionType.equals(OptionType.Explicit)){
            optionId = getExplicitOption(hashedOption, option, negativeHashedOption, negativeOption);
        }
        else if (optionType.equals(OptionType.Implicit)) {
            optionId = getImplicitOption(hashedOption, option, negativeHashedOption, negativeOption);
        }
        else if (optionType.equals(OptionType.Enchant)){
            optionId = getEnchantedOption(hashedOption, option, negativeHashedOption, negativeOption);
        }
        return optionId;
    }

    private String getExplicitOption(String hashedOption, String option, String negativeHashedOption, String negativeOption) {
        Explicit explicit;

        explicit = explicitRepository.findByTextRegex(hashedOption);
        if (explicit != null) {
            return explicit.getTextId();
        }

        explicit = explicitRepository.findByText(option);
        if (explicit != null) {
            return explicit.getText();
        }

        explicit = explicitRepository.findByText(negativeOption);
        if (explicit != null) {
            return explicit.getTextId();
        }

        explicit = explicitRepository.findByTextRegex(negativeHashedOption);
        if(explicit != null) {
            return explicit.getTextId();
        }

        return null;
    }

    private String getImplicitOption(String hashedOption, String option, String negativeHashedOption, String negativeOption) {
        Implicit implicit;

        implicit = implicitRepository.findByTextRegex(hashedOption);
        if (implicit != null) {
            return implicit.getTextId();
        }

        implicit = implicitRepository.findByText(option);
        if (implicit != null) {
            return implicit.getTextId();
        }

        implicit = implicitRepository.findByText(negativeOption);
        if (implicit != null) {
            return implicit.getTextId();
        }

        implicit = implicitRepository.findByTextRegex(negativeHashedOption);
        if (implicit != null) {
            return implicit.getTextId();
        }

        return null;
    }

    private String getEnchantedOption(String hashedOption, String option, String negativeHashedOption, String negativeOption) {
        Enchant enchant;
        enchant = enchantRepository.findByTextRegex(hashedOption);
        if (enchant != null) {
            return enchant.getTextId();
        }

        enchant = enchantRepository.findByText(option);
        if (enchant != null) {
            return enchant.getTextId();
        }

        enchant = enchantRepository.findByText(negativeOption);
        if (enchant != null) {
            return enchant.getTextId();
        }

        enchant = enchantRepository.findByTextRegex(negativeHashedOption);
        if (enchant != null) {
            return enchant.getTextId();
        }

        return null;
    }

    private String exceptionOptionCase(Pattern compile, ItemType type) {
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
}
