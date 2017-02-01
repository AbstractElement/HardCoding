package com.entity;

import com.service.parse.ParseMagicService;
import com.skills.Magic;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class Hero extends Entity{
    private HashMap<String, Magic> magics = null;

    public Hero() throws IOException {
        super();
        magics = ParseMagicService.getAllMagic();
    }

    public HashMap<String, Magic> getMagics() {
        return magics;
    }

}
