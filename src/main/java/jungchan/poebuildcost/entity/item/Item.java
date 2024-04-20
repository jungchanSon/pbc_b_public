package jungchan.poebuildcost.entity.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
