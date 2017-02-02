package com.entity.skills.ext;

import com.entity.skills.Magic;

import java.io.Serializable;

/**
* Created by Vladislav on 30.01.2017.
*/
public class ProtectiveMagic extends Magic implements Serializable{

    public ProtectiveMagic(String nameMagic, int strength, int health) {
        super(nameMagic, strength, health);
    }

}
