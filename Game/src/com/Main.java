package com;

import com.service.GameProcessService;
import com.service.parse.ParseItemsService;
import org.jdom2.JDOMException;

import java.io.IOException;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, JDOMException {
        ParseItemsService.parseWeapon();
        GameProcessService.startGame();
    }
}
