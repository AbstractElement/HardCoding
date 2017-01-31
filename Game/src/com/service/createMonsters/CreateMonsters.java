package com.service.createMonsters;

import com.entity.Monster;
import com.item.Item;
import com.service.parse.ParseItemsService;
import com.service.parse.ParseNameMonsters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

/**
 * Created by Vladislav on 31.01.2017.
 */
public class CreateMonsters {
    private static LinkedList<Monster> listMonsters = new LinkedList<Monster>();

    public static LinkedList<Monster> createMonster() throws IOException {
        ArrayList<String> nameMonsters = ParseNameMonsters.getNameMonster();
        for (int i = 0; i < nameMonsters.size(); i++){
            Item newItem = getItemForMonster();
            listMonsters.add(i, new Monster(nameMonsters.get(i), i, newItem));
        }
        return listMonsters;
    }

    private static Item getItemForMonster() throws IOException {
        Random random = new Random();
        int amountItems = ParseItemsService.getAllItems().size();
        int number = random.nextInt(amountItems*2);
        if (number <= amountItems){
            Item newItem = ParseItemsService.parseArmor().get(number);
            newItem.setUse(true);
            return newItem;
        }
        return null;
    }
}
