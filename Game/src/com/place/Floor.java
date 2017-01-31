package com.place;

import com.entity.Monster;

import java.util.Map;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class Floor {
    private int levelFloor;
    private Map<Integer, Monster[]> monsterMap;

    public Floor(int levelFloor, Map<Integer, Monster[]> monsterMap) {
        this.levelFloor = levelFloor;
        this.monsterMap = monsterMap;
    }

    public int getLevelFloor() {
        return levelFloor;
    }

    public void setLevelFloor(int levelFloor) {
        this.levelFloor = levelFloor;
    }

    public Map<Integer, Monster[]> getMonsterMap() {
        return monsterMap;
    }

    public void setMonsterMap(Map<Integer, Monster[]> monsterMap) {
        this.monsterMap = monsterMap;
    }
}
