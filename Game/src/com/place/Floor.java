package com.place;

import com.entity.Monster;

/**
 * Created by Vladislav on 30.01.2017.
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
