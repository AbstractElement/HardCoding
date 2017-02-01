package com.entity;

import com.characteristics.Characteristics;
import com.item.Item;

/**
 * Created by Vladislav on 30.01.2017.
 */
public abstract class Entity {
    protected int level = 0;
    protected Characteristics characteristics = null;
    protected Item item = new Item();

    public Entity(int level, Item item) {
        this.level = level;
        this.characteristics = new Characteristics(0, 0, 70, 0);
        if (item != null)
            this.item = item;
    }

    public Entity() {
        this.level = 0;
        this.characteristics = new Characteristics(5, 5, 100, 5);
    }

    public String toString() {
        String sentence = "[Уровень: " + getLevel() +
                "\nХарактеристики:" +
                "\n Сила: " + getCharacteristics().getStrength() +
                "\n Ловкость: " + getCharacteristics().getDexterity() +
                "\n Здоровье: " + getCharacteristics().getHealth() +
                "\n Броня: " + getCharacteristics().getArmor() + "]";
        if (!getItem().getName().equals("Нет"))
            sentence += "\nСнаряжение: " + getItem().toString() + "]";
        return sentence;
    }

    public int getLevel() {
        return level;
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
