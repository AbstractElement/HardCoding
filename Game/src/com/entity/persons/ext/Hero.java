package com.entity.persons.ext;

import com.entity.persons.Entity;
import com.service.parse.ParseMagicService;
import com.entity.skills.Magic;
import org.jdom2.JDOMException;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Vladislav on 30.01.2017.

 * Класс главного героя (Hero), расширяет класс сущности (Entity).
 * Содержит поле, хранящее все магических умения.
 */
public class Hero extends Entity implements Serializable{
    private HashMap<String, Magic> magics = null;

    public Hero() throws IOException, JDOMException {
        super();
        magics = ParseMagicService.getAllMagic();
    }

    public HashMap<String, Magic> getMagics() {
        return magics;
    }

}
