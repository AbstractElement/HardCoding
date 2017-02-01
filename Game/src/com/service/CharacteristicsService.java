package com.service;


import com.content.Message;
import com.entity.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class CharacteristicsService {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private static boolean isActivate = false;
    private static int points = 0;

    private static void addStrength(Hero hero){
        int add = hero.getCharacteristics().getStrength();
        hero.getCharacteristics().setStrength(++add);
    }

    private static void addDexterity(Hero hero){
        int add = hero.getCharacteristics().getDexterity();
        hero.getCharacteristics().setDexterity(++add);
    }

    private static void addHealth(Hero hero){
        int add = hero.getCharacteristics().getHealth();
        hero.getCharacteristics().setHealth(add + 10);
    }

    private static void addArmor(Hero hero){
        int add = hero.getCharacteristics().getArmor();
        hero.getCharacteristics().setArmor(++add);
    }

    public static void addPoints() {
        CharacteristicsService.points += 3;
    }

    public static void upLevel(Hero hero) throws IOException {
        for(; points > 0 ; points--) {
            System.out.println("У вас есть " + points + " ед. улучшения");
            System.out.println(Message.UP_LEVEL_CHARACTERISTICS);
            String choose = reader.readLine();
            if (choose.equals("1")) {
                addStrength(hero);
            } else if (choose.equals("2")) {
                addDexterity(hero);
            } else if (choose.equals("3")) {
                addHealth(hero);
            } else if (choose.equals("4")) {
                addArmor(hero);
            }
        }
//        isActivate = false;
    }
}
