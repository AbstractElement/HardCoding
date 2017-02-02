package com.entity.place;

import com.entity.persons.ext.Monster;

/**
 * Created by Vladislav on 30.01.2017.

 * Класс этажа (Floor).
 * Содержит массив сонстров, который находятся на заданном этаже
 */
public class Floor {
    private Monster[] monsterMap;

    public Floor(Monster[] monsterMap) {
        this.monsterMap = monsterMap;
    }

    public Monster[] getMonsterMap() {
        return monsterMap;
    }
}
