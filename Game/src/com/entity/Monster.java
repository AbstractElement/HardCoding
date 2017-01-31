package com.entity;

import com.item.Item;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class Monster extends Entity {
    private String nameMonster;
    private Item item;

    public Monster(String nameMonster, int level, Item item){
        super(level);
        this.nameMonster = nameMonster;
        this.item = item;

    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getNameMonster() {
        return nameMonster;
    }

    public void setNameMonster(String nameMonster) {
        this.nameMonster = nameMonster;
    }
}
