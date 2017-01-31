package com.skills.impl;

import com.skills.Magic;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class OffensiveMagic implements Magic{
    private String nameMagic = "";
    private int subHealth = 0;
    private int subStrength = 0;
    private boolean use = false;

    public OffensiveMagic(String nameMagic, int subHealth, int subStrength) {
        this.nameMagic = nameMagic;
        this.subStrength = subStrength;
        this.subHealth = subHealth;
    }

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public String getNameMagic() {
        return nameMagic;
    }

    public int getSubHealth() {
        return subHealth;
    }

    public int getSubStrength() {
        return subStrength;
    }
}
