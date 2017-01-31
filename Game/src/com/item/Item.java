package com.item;

/**
 * Created by Vladislav on 30.01.2017.
 */
public abstract class Item {
    protected String name;
    protected int dexterity;
    protected String skill;
    protected boolean use = false;
    protected int addCharacteristic;

    public Item(String name, int dexterity, int addCharacteristic, String skill) {
        this.name = name;
        this.dexterity = dexterity;
        this.addCharacteristic = addCharacteristic;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
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
}
