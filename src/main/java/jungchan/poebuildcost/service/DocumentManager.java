package jungchan.poebuildcost.service;

import jungchan.poebuildcost.entity.item.Item;
import org.w3c.dom.Document;

import java.util.ArrayList;

public interface DocumentManager {
    ArrayList<Item> parseItems(Document document);
}
