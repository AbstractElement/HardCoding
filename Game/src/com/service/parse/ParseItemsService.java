package com.service.parse;

import com.item.Item;
import com.item.impl.Armor;
import com.item.impl.Weapon;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class ParseItemsService {
    private static BufferedReader reader;
    private static ArrayList<Item> itemArrayList = new ArrayList<Item>();
    private final static String PATH_ARMOR = "src/resources/armor";
    private final static String PATH_WEAPONS = "src/resources/weapons";

    public static ArrayList<Item> parseArmor() throws IOException {
        reader = new BufferedReader(new FileReader(new File(PATH_ARMOR)));
        while (reader.ready()){
            String[] line = reader.readLine().split(":");
            itemArrayList.add(new Armor(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3]));
        }
        reader.close();
        return itemArrayList;
    }

    public static ArrayList<Item> parseWeapon() throws IOException {
        reader = new BufferedReader(new FileReader(new File(PATH_WEAPONS)));
        while (reader.ready()){
            String[] line = reader.readLine().split(":");
            itemArrayList.add(new Weapon(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3]));
        }
        reader.close();
        return itemArrayList;
    }

    public static ArrayList<Item> getAllItems() throws IOException {
        parseArmor();
        return parseWeapon();
    }
}
