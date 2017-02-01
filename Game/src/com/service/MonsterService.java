package com.service;

import com.entity.Hero;
import com.entity.Monster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vladislav on 01.02.2017.
 */
public class MonsterService {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static boolean isUseItem(Monster monster){
        if (monster.getItem() != null)
            return true;
        else return false;
    }

    public static void takeThisWeapon(Monster monster, Hero hero) throws IOException {
        System.out.println("Хотите подобрать " + monster.getItem().getName() + "?" +
                "\n" + monster.getItem().toString() + "\n1. Да \n2. Нет");
        String choose = reader.readLine();
        if (choose.equals("1"))
            hero.setItem(monster.getItem());
        else if (choose.equals("2"))
            return;
    }
}
