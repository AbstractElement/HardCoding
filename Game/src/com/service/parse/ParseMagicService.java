package com.service.parse;

import com.entity.skills.Magic;
import com.entity.skills.ext.OffensiveMagic;
import com.entity.skills.ext.ProtectiveMagic;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vladislav on 31.01.2017.
 *
 * Класс, котрый считывает данные о магии из файла и заносит их в массив.
 */
public class ParseMagicService {
    private static HashMap<String, Magic> magics = new HashMap<String, Magic>();
    private final static String MAGIC = "src/resources/magic.xml";

    public static HashMap<String, Magic> getOffensiveMagic() throws IOException, JDOMException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(MAGIC);
        Element element = document.getRootElement();
        List<Element> elementList = element.getChildren();
        for (Element element1 : elementList) {
            if (element1.getName().equals("offensiveMagic")) {
                String name = element1.getAttributeValue("name");
                int strength = Integer.parseInt(element1.getAttributeValue("strength"));
                int health = Integer.parseInt(element1.getAttributeValue("health"));
                OffensiveMagic offensiveMagic = new OffensiveMagic(name, strength, health);
                magics.put(name, offensiveMagic);
            } else if (element1.getName().equals("protectiveMagic")) {
                String name = element1.getAttributeValue("name");
                int health = Integer.parseInt(element1.getAttributeValue("health"));
                ProtectiveMagic protectiveMagic = new ProtectiveMagic(name, 0, health);
                magics.put(name, protectiveMagic);
            }
        }
        return magics;
    }

    public static HashMap<String, Magic> getAllMagic() throws IOException, JDOMException {
        return getOffensiveMagic();
    }
}
