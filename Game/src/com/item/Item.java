package com.item;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class Item {
    protected String name;
    protected String skill;
    protected boolean use = false;
    protected int strength;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
