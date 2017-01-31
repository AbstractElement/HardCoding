package com.service;


import com.entity.Hero;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class CharacteristicsService {

    public static void addStrength(Hero hero){
        int add = hero.getCharacteristics().getStrength();
        hero.getCharacteristics().setStrength(++add);
    }

    public static void addDexterity(Hero hero){
        int add = hero.getCharacteristics().getDexterity();
        hero.getCharacteristics().setDexterity(++add);
    }

    public static void addHealth(Hero hero){
        int add = hero.getCharacteristics().getHealth();
        hero.getCharacteristics().setHealth(++add);
    }

    public static void addArmor(Hero hero){
        int add = hero.getCharacteristics().getArmor();
        hero.getCharacteristics().setArmor(++add);
    }
}
