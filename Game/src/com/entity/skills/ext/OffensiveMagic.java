package com.entity.skills.ext;

import com.entity.skills.Magic;

import java.io.Serializable;

/**
* Created by Vladislav on 30.01.2017.
*/
public class OffensiveMagic extends Magic implements Serializable{

    public OffensiveMagic(String nameMagic, int strength, int health) {
        super(nameMagic, strength, health);
    }

}
