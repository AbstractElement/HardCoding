package com.skills.impl;

import com.skills.Magic;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class ProtectiveMagic implements Magic{
    private String nameMagic = "";
    private int addHealth = 0;
    private int addArmor = 0;
    private boolean use = false;

    public ProtectiveMagic(String nameMagic, int addHealth, int addArmor) {
        this.nameMagic = nameMagic;
        this.addArmor = addArmor;
        this.addHealth = addHealth;
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

    public int getAddHealth() {
        return addHealth;
    }

    public int getAddArmor() {
        return addArmor;
    }
}
