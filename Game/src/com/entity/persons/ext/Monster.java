package com.entity.persons.ext;

import com.entity.persons.Entity;
import com.entity.item.Item;

/**
 * Created by Vladislav on 30.01.2017.

 * Класс описывающий монстров в игре (Monster), расширяет класс сущности (Entity)
 * Содержит поле, хранящее названия монтра.
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
