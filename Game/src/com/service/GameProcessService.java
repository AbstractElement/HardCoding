package com.service;

import com.content.Message;
import com.content.ReadHistory;
import com.entity.persons.ext.Hero;
import com.entity.persons.ext.Monster;
import com.entity.place.Floor;
import com.entity.skills.Magic;
import com.fight.Fight;
import com.service.createMonsters.CreateMonsters;
import org.jdom2.JDOMException;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Vladislav on 01.02.2017.

 * Класс, отвечающий за процесс игры, сохранение и загрузку.
 */
public class GameProcessService {
    private static final String PATH_SAVE = "src/resources/save";
    private static Hero hero;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int amountDead = 0;

    public static void startGame() throws IOException, InterruptedException, JDOMException {
        LinkedList<Monster> monsters = CreateMonsters.createMonster();
        LinkedList<Floor> floors = new LinkedList<>();
        loadGame();
        System.out.println(ReadHistory.getStory());
        for (int i = 0; i < monsters.size()-2; i += 3)
            floors.add(new Floor(new Monster[]{monsters.get(i), monsters.get(i+1), monsters.get(i+2)}));
        Monster victim = new Monster();
        int level = hero.getLevel();
        for (; level < floors.size();) {
            if (level == floors.size()-1 && amountDead == 3){
                System.out.println(Message.WIN_MESSAGE);
                reader.close();
                System.exit(0);
            }
            else
                level = upFloor(level);
            System.out.println("Вы находитесь на " + level + " этаже.");
            System.out.println(Message.FIRST_CHOOSE_MENU);
            int chooseDoor = Integer.parseInt(reader.readLine());
            openTheDoor(floors, victim, hero, level, chooseDoor - 1);
        }
    }

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

    public static void loadGameProcess(){
        try{
            FileInputStream fileInputStream = new FileInputStream(PATH_SAVE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            hero = (Hero)objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            hero = null;
        }
    }

    public static boolean choose(Hero hero, Monster victim) throws IOException, JDOMException {
        while (victim.getCharacteristics().getHealth() > 0 && hero.getCharacteristics().getHealth() > 0) {
            System.out.println(Message.SECOND_CHOOSE_MENU);
            String choose = reader.readLine();
            switch (choose){
                case "1" : {
                    if (Fight.hit(hero, victim)) {
                        System.out.print("Вы удачно атакуете! ");
                        Fight.damage(hero, victim);
                        if (closeTheDoor(victim)) return true;
                    }
                    System.out.print("Враг нападает на вас! ");
                    if (Fight.hit(victim, hero)) {
                        Fight.damage(victim, hero);
                        if(Fight.isDead(hero)){
                            System.out.println("Вы были убиты! Убийца (" + victim.getNameMonster() + ")");
                            System.exit(0);
                        }
                        System.out.println("Ваше здоровье: " + hero.getCharacteristics().getHealth());
                    }
                    break;
                }
                case "2" : {
                    System.out.println(Message.THIRD_CHOOSE_MENU);
                    String chooseMagic = reader.readLine();
                    switch (chooseMagic) {
                        case "1": {
                            Fight.useProtectiveMagic(hero, "Регенерация");
                            break;
                        }
                        case "2": {
                            Fight.useOffensiveMagic(victim, "Огненный удар");
                            Fight.damage(hero, victim);
                            if (closeTheDoor(victim)) return true;
                            break;
                        }
                        case "0": {
                            break;
                        }
                    }
                    break;
                }
                case "3":{
                    if (!hero.getItem().getName().equals("Нет")) {
                        Fight.useMagicOfWeapons(hero, victim);
                        Fight.damage(hero, victim);
                        if (closeTheDoor(victim)) return true;
                        System.out.print("Враг нападает на вас! ");
                        if (Fight.hit(victim, hero)) {
                            Fight.damage(victim, hero);
                            if (Fight.isDead(hero)) {
                                System.out.println("Вы были убиты! Убийца (" + victim.getNameMonster() + ")");
                                System.exit(0);
                            }
                            System.out.println("Ваше здоровье: " + hero.getCharacteristics().getHealth());
                        }
                    }
                    else
                        System.out.println(Message.NO_MAGIC_SKILL);
                    break;
                }
                case "4": {
                    System.out.println(hero.toString());
                    break;
                }
                case "5": {
                    System.out.println(victim.toString());
                    break;
                }
                case "6": {
                    System.out.println(Message.YOU_FLED);
                    return false;
                }
                case "0": {
                    GameProcessService.saveGameProcess(hero);
                    System.exit(0);
                }
            }
        }
        return true;
    }

    public static int upFloor(int i) throws IOException {
        if (amountDead == 3){
            CharacteristicsService.addPoints();
            System.out.println(Message.UP_LEVEL_MESSAGE);
            amountDead = 0;
            CharacteristicsService.upLevel(hero);
            System.out.println(Message.NEXT_FLOOR);
            hero.setLevel(hero.getLevel() + 1);
            return ++i;
        }
        return i;
    }

    public static void openTheDoor(LinkedList<Floor> floors, Monster victim, Hero hero, int level, int idMonster)
            throws IOException, InterruptedException, JDOMException {
        if (floors.get(level).getMonsterMap()[idMonster] != null) {
            victim = floors.get(level).getMonsterMap()[idMonster];
            System.out.println(victim.getNameMonster());
            if(choose(hero, victim)) {
                hero.getCharacteristics().setHealth(100);
                floors.get(level).getMonsterMap()[idMonster] = null;
                amountDead++;
                Magic.setUse(false);
            }
        }
        else{
            System.out.println(Message.YOU_KILLED_ALL);
        }
    }

    public static boolean closeTheDoor(Monster victim){
        if (Fight.isDead(victim)){
            if(ItemService.isUseItem(victim) && !victim.getItem().getName().equals("Нет"))
                try {
                    ItemService.takeThisWeapon(victim, hero);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            System.out.println(Message.YOU_WIN_IN_THIS_FIGHT);
            return true;
        }
        System.out.println("Здоровье врага: " + victim.getCharacteristics().getHealth());
        return false;
    }

    public static void loadGame() throws JDOMException {
        System.out.println("1. Загрузить последнее сохранение \n2. Начать новую игру");
        String start;
        try {
            start = reader.readLine();
            if (start.equals("1")) {
                GameProcessService.loadGameProcess();
                if (hero == null) {
                    System.out.println("Сохранения отсутствуют!");
                    hero = new Hero();
                }
            }
            if (start.equals("2"))
                hero = new Hero();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
