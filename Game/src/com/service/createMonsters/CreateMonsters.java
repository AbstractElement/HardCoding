package com.service.createMonsters;

import com.entity.characteristics.Characteristics;
import com.entity.persons.ext.Monster;
import com.entity.item.Item;
import com.service.parse.ParseItemsService;
import com.service.parse.ParseNameMonsters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Vladislav on 31.01.2017.

 * Класс по созданию монстров (CreateMonster).
 * Содержит коллецкцию, которая ранит всех монстров.
 */
public class CreateMonsters {
    private static LinkedList<Monster> listMonsters = new LinkedList<Monster>();

    /**
     * Функция, которая создает объеты монстров, задает им характеристики и оружие
     * @return - возвращает коллекцию монстров
     * @throws IOException
     */
    public static LinkedList<Monster> createMonster() throws IOException {
        ArrayList<String> nameMonsters = ParseNameMonsters.getNameMonster();
        for (int i = 0; i < nameMonsters.size(); i++){
            Item newItem = getItemForMonster();
            String[] monster = nameMonsters.get(i).split(":");
            listMonsters.add(i, new Monster(monster[0], i, newItem));
            listMonsters.get(i).setCharacteristics(
                    new Characteristics(Integer.parseInt(monster[1]), Integer.parseInt(monster[2]),
                            Integer.parseInt(monster[3]), Integer.parseInt(monster[4])));
        }
        return listMonsters;
    }

    /**
     * Функция, которая высчитывает шанс выпадения оружие для текущего монстра
     * @return - возвращает либо объект оружия (Item), либо null
     * @throws IOException
     */
    private static Item getItemForMonster() throws IOException {
        Random random = new Random();
        int amountItems = ParseItemsService.getAllItems().size();
        int number = random.nextInt(amountItems*2);
        if (number < amountItems)
            return ParseItemsService.getAllItems().get(number);
        return null;
    }
}
