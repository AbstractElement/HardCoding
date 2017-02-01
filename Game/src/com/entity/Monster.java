package com.entity;

import com.item.Item;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class Monster extends Entity {
    private String nameMonster;

    public Monster(){

    }
    public Monster(String nameMonster, int level, Item item){
        super(level, item);
        this.nameMonster = nameMonster;
    }

    public String getNameMonster() {
        return nameMonster;
    }

}
