package com.service.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Vladislav on 31.01.2017.
 */
public class ParseNameMonsters {
    private static ArrayList<String> nameMonster = new ArrayList<String>();
    private final static String NAME_MONSTERS = "src/resources/monsters";

    public static ArrayList<String> getNameMonster() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(NAME_MONSTERS)));
        while (reader.ready()){
            nameMonster.add(reader.readLine());
        }
        reader.close();
        return nameMonster;
    }
}
