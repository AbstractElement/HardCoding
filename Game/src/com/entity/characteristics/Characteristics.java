package com.entity.characteristics;

import java.io.Serializable;

/**
 * Created by Vladislav on 30.01.2017.

 * Класс, который включает в себя основные характеристики (Characteristics) персонажа
 * (силу, ловкость, здоровье, броню).
 *
 */
public class Characteristics implements Serializable{
    private int strength;
    private int dexterity;
    private int health;
    private int armor;

    public Characteristics(int strength, int armor, int health, int dexterity) {
        this.strength = strength;
        this.armor = armor;
        this.health = health;
        this.dexterity = dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public int getHealth() {
        return health;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getArmor() {
        return armor;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

}
