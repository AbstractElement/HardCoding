package com.skills;

/**
 * Created by Vladislav on 30.01.2017.
 */
public abstract class Magic {
    private String nameMagic = "";
    private int health = 0;
    private int strength = 0;
    private static boolean use = false;

    public Magic(String nameMagic, int strength, int health) {
        this.nameMagic = nameMagic;
        this.strength = strength;
        this.health = health;
    }

    public String getNameMagic() {
        return nameMagic;
    }

    public void setNameMagic(String nameMagic) {
        this.nameMagic = nameMagic;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isUse() {
        return use;
    }

    public static void setUse(boolean use) {
        Magic.use = use;
    }
}
