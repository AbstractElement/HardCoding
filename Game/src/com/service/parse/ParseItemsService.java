package com.service.parse;

import com.entity.item.Item;
import com.entity.persons.ext.Monster;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 30.01.2017.

 * Класс, который считывает данные о снаряжении из файла и заносит их в массив.
 */
public class ParseItemsService {
    private static ArrayList<Item> itemArrayList = new ArrayList<Item>();
    private final static String PATH_WEAPONS = "src/resources/weapons.xml";

    public static ArrayList<Item> parseWeapon() throws IOException, JDOMException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(PATH_WEAPONS);
        Element element = document.getRootElement();
        List<Element> elementList = element.getChildren();
        for (Element element1 : elementList) {
            Item item = new Item();
            int strength = Integer.parseInt(element1.getAttribute("strength").getValue());
            String skill = element1.getAttribute("skill").getValue();
            String name = element1.getAttribute("name").getValue();
            item.setStrength(strength);
            item.setSkill(skill);
            item.setName(name);
            itemArrayList.add(item);
        }
        return itemArrayList;
    }

    public static ArrayList<Item> getAllItems() throws IOException {
        return itemArrayList;
    }
}
