package com;

import com.entity.Hero;
import com.entity.Monster;
import com.item.Item;
import com.place.Floor;
import com.service.createMonsters.CreateMonsters;
import com.service.parse.ParseItemsService;

import java.io.IOException;
import java.util.*;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Item> items = ParseItemsService.getAllItems();
        Map<Integer, Monster> map = new TreeMap<Integer, Monster>();
        Hero hero = new Hero();
        hero.toString();
        CreateMonsters.createMonster();
    }
}
