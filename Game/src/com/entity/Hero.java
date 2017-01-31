package com.entity;

import com.item.Item;
import com.service.parse.ParseMagicService;
import com.skills.Magic;

import java.io.IOException;
import java.util.ArrayList;
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
//
//    public void setItem(Item item){
//        for (int i = 0; i < items.length; i++)
//            if (items[i] == null){
//                items[i] = item;
//                break;
//            }
//    }


    public HashMap<String, Magic> getMagics() {
        return magics;
    }

    public void setMagics(HashMap<String, Magic> magics) {
        this.magics = magics;
    }
}
