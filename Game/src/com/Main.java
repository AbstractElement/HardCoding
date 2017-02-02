package com;

import com.content.Message;
import com.content.ReadHistory;
import com.entity.persons.ext.Hero;
import com.entity.persons.ext.Monster;
import com.fight.Fight;
import com.entity.place.Floor;
import com.service.CharacteristicsService;
import com.service.GameProcessService;
import com.service.ItemService;
import com.service.createMonsters.CreateMonsters;
import com.service.parse.ParseItemsService;
import com.entity.skills.Magic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Hero hero;
    private static int amountDead = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        ParseItemsService.parseWeapon();
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

    public static boolean choose(Hero hero, Monster victim) throws IOException{
        while (victim.getCharacteristics().getHealth() > 0 && hero.getCharacteristics().getHealth() > 0) {
            System.out.println(Message.SECOND_CHOOSE_MENU);
            int choose = Integer.parseInt(reader.readLine());
            switch (choose){
                case 1 : {
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
                case 2 : {
                    System.out.println(Message.THIRD_CHOOSE_MENU);
                    int chooseMagic = Integer.parseInt(reader.readLine());
                    switch (chooseMagic) {
                        case 1: {
                            Fight.useProtectiveMagic(hero, "Регенерация");
                            break;
                        }
                        case 2: {
                            Fight.useOffensiveMagic(victim, "Огненный удар");
                            Fight.damage(hero, victim);
                            if (closeTheDoor(victim)) return true;
                            break;
                        }
                        case 0: {
                            break;
                        }
                    }
                    break;
                }
                case 3:{
                    if (!hero.getItem().getName().equals("Нет")){
                        Fight.useMagicOfWeapons(hero, victim);
                        Fight.damage(hero, victim);
                        if (closeTheDoor(victim)) return true;
                    }
                    else
                        System.out.println(Message.NO_MAGIC_SKILL);
                    break;
                }
                case 4: {
                    System.out.println(hero.toString());
                    break;
                }
                case 5: {
                    System.out.println(victim.toString());
                    break;
                }
                case 6: {
                    System.out.println(Message.YOU_FLED);
                    return false;
                }
                case 0: {
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
            throws IOException, InterruptedException {
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

    public static void loadGame(){
        System.out.println("1. Загрузить последнее сохранение \n2. Начать новую игру");
        String start;
        try {
            start = reader.readLine();
            if (start.equals("1"))
                if ((hero = GameProcessService.loadGameProcess()) == null)
                    hero = new Hero();
            if (start.equals("2"))
                hero = new Hero();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
