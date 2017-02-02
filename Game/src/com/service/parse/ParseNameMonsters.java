package com.service.parse;

import com.entity.characteristics.Characteristics;
import com.entity.persons.ext.Monster;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Vladislav on 31.01.2017.
 * <p/>
 * Класс, который считывает данные о монстрах из файла и заносит их в массив
 */
public class ParseNameMonsters {
    private static ArrayList<Monster> nameMonster = new ArrayList<>();
    private final static String NAME_MONSTERS = "src/resources/monsters.xml";

    public static ArrayList<Monster> getNameMonster() throws IOException, JDOMException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(NAME_MONSTERS);
        Element element = document.getRootElement();
        List<Element> elementList = element.getChildren();
        for (Element element1 : elementList) {
            Monster monster = new Monster();
            int strength = Integer.parseInt(element1.getAttribute("strength").getValue());
            int armor = Integer.parseInt(element1.getAttribute("armor").getValue());
            int health = Integer.parseInt(element1.getAttribute("health").getValue());
            int dexterity = Integer.parseInt(element1.getAttribute("dexterity").getValue());
            String name = element1.getAttribute("name").getValue();
            Characteristics characteristics = new Characteristics(strength, armor, health, dexterity);
            monster.setCharacteristics(characteristics);
            monster.setNameMonster(name);
            nameMonster.add(monster);
        }
        return nameMonster;
    }
}
