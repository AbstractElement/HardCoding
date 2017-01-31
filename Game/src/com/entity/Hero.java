package com.entity;

import com.item.Item;
import com.service.parse.ParseMagicService;
import com.skills.Magic;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class Hero extends Entity{
    private final static int AMOUNT_ITEMS = 2;
    private ArrayList<Magic> magics = null;
    protected Item[] items = new Item[AMOUNT_ITEMS];

    public Hero() throws IOException {
        super();
        magics = ParseMagicService.getAllMagic();
    }

    public void setItem(Item item){
        for (int i = 0; i < items.length; i++)
            if (items[i] == null){
                items[i] = item;
                break;
            }
    }

    public ArrayList<Magic> getMagics() {
        return magics;
    }

    public void setMagics(ArrayList<Magic> magics) {
        this.magics = magics;
    }
}
