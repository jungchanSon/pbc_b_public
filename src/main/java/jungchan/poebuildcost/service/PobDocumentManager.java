package jungchan.poebuildcost.service;

import jungchan.poebuildcost.entity.item.Item;
import jungchan.poebuildcost.entity.item.ItemType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class PobDocumentManager implements DocumentManager {

    private ThreadLocal<NodeList> itemsThreadLocal = new ThreadLocal<>();

    @Override
    public ArrayList<Item> parseItems(Document document) {

        itemsThreadLocal.set(document.getElementsByTagName("Item"));

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
        NodeList items = itemsThreadLocal.get();
        for (int i = 0; i < items.getLength(); i++) {
            Node item = items.item(i);
            String itemId = item.getAttributes().getNamedItem("id").getNodeValue();
            if (itemId.equals(socketId)) {
                String textContent = item.getTextContent();
                Item equip = Item.createItem(itemType, textContent);
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

        ArrayList<Item> jewels = new ArrayList<>();
        NodeList items = itemsThreadLocal.get();

        for (int i = 0; i < items.getLength(); i++) {
            Node item = items.item(i);
            String itemId = item.getAttributes().getNamedItem("id").getNodeValue();
            if (socketIds.contains(itemId)) {
                String textContent = item.getTextContent();
                Item jewel = Item.createItem(ItemType.Jewel, textContent);
                jewels.add(jewel);
            }
        }

        return jewels;
    }
}
