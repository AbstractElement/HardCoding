package com.service;

import com.entity.persons.ext.Hero;

import java.io.*;

/**
 * Created by Vladislav on 01.02.2017.

 * Класс, отвечающий за сохранение и загрузку игрового процесса.
 */
public class GameProcessService {
    private static final String PATH_SAVE = "src/resources/save";

    public static void saveGameProcess(Hero hero){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH_SAVE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hero);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Hero loadGameProcess(){
        Hero hero;
        try{
            FileInputStream fileInputStream = new FileInputStream(PATH_SAVE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            hero = (Hero)objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            return hero;
        } catch (IOException | ClassNotFoundException e) {
            return hero = null;
        }
    }
}
