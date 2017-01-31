package com.entity;

import com.characteristics.Characteristics;
import com.item.Item;

/**
 * Created by Vladislav on 30.01.2017.
 */
public abstract class Entity {
    protected int level = 0;
    protected Characteristics characteristics = null;
    protected Item item;

    public Entity(int level, Item item) {
        this.level = level;
        this.characteristics = new Characteristics(0, 0, 70, 0);
        this.item = item;
    }

    public Entity() {
        this.level = 0;
        this.characteristics = new Characteristics(1, 1, 100, 1);
        item = new Item();
    }

    public int getLevel() {
        return level;
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setLevel(int level) {
        this.level = level;
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
