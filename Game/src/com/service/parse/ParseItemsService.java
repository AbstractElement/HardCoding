package com.service.parse;

import com.entity.item.Item;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Vladislav on 30.01.2017.

 * Класс, который считывает данные о снаряжении из файла и заносит их в массив.
 */
public class ParseItemsService {
    private static ArrayList<Item> itemArrayList = new ArrayList<Item>();
    private final static String PATH_WEAPONS = "src/resources/weapons";

    public static ArrayList<Item> parseWeapon() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(PATH_WEAPONS)));
        while (reader.ready()){
            String[] line = reader.readLine().split(":");
            itemArrayList.add(new Item(line[0], Integer.parseInt(line[1]), line[2]));
        }
        reader.close();
        return itemArrayList;
    }

    public static ArrayList<Item> getAllItems() throws IOException {
        return itemArrayList;
    }
}
