package com.entity.item;

import java.io.Serializable;

/**
 * Created by Vladislav on 30.01.2017.

 * Класс вещей(Item).
 * (название предмета, его способность, добавочная сила)
 */
public class Item implements Serializable{
    protected String name = "Нет";
    protected String skill = "Нет";
    protected int strength = 0;

    public Item(){

    }

    public Item(String name, int strength, String skill) {
        this.name = name;
        this.strength = strength;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public String getSkill() {
        return skill;
    }

    public int getStrength() {
        return strength;
    }
    @Override
    public String toString() {
        return name + "\n" + "Способность: " + skill + "; Сила: " + strength;
    }
}
