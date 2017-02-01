package com;

import com.content.Message;
import com.entity.Hero;
import com.entity.Monster;
import com.fight.Fight;
import com.place.Floor;
import com.service.CharacteristicsService;
import com.service.MonsterService;
import com.service.createMonsters.CreateMonsters;
import com.service.parse.ParseItemsService;
import com.skills.Magic;

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
        LinkedList<Floor> floors = new LinkedList<Floor>();
        hero = new Hero();
        for (int i = 0; i < monsters.size()-2; i += 3)
            floors.add(new Floor(new Monster[]{monsters.get(i), monsters.get(i+1), monsters.get(i+2)}));
        Monster victim = new Monster();
        for (int i = 0; i < floors.size();) {
            if (i == floors.size()-1 && amountDead == 3){
                System.out.println("Поздравляю!!! Вы прошли игру и очистили башню от нечисти!");
                System.exit(0);
            }
            else
                i = upFloor(i);
            System.out.println(Message.FIRST_CHOOSE_MENU);
            int chooseDoor = Integer.parseInt(reader.readLine());
            openTheDoor(floors, victim, hero, i, chooseDoor - 1);
        }
    }

    public static boolean choose(Hero hero, Monster victim) throws IOException, InterruptedException {
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
//                            if (Fight.isDead(victim)){
//                                if(MonsterService.isUseItem(victim)  && !victim.getItem().getName().equals("Нет"))
//                                    MonsterService.takeThisWeapon(victim, hero);
//                                System.out.println("Вы победили в этой битве!");
//                                return true;
//                            }

                            break;
                        }
//                        case 3: {
//                            Fight.useOffensiveMagic(victim, "Морозный удар");
//                            if (Fight.isDead(victim)){
//                                if(MonsterService.isUseItem(victim))
//                                    MonsterService.takeThisWeapon(victim, hero);
//                                System.out.println("Вы победили в этой битве!");
//                                return true;
//                            }
//                            break;
//                        }
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
//                        if (Fight.isDead(victim)){
//                            if(MonsterService.isUseItem(victim) && !victim.getItem().getName().equals("Нет"))
//                                MonsterService.takeThisWeapon(victim, hero);
//                            System.out.println("Вы победили в этой битве!");
//                            return true;
//                        }
                    }
                    else
                        System.out.println("Ваше снаряжение не имеет магических способностей!");
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
                case 0: {
                    System.out.println("Вам удалось сбежать!");
                    return false;
                }
            }
        }
        return true;
    }

    public static int upFloor(int i) throws IOException {
        if (amountDead == 3){
            CharacteristicsService.addPoints();
            System.out.println("Вы убили всех монтстров на этом этаже и можете двигаться дальше." +
                    "\nВам предоставлено 3 очка улучшения характеристик");
//            int choose = Integer.parseInt(reader.readLine());
//            switch (choose){
//                case 1 : {
//                    amountDead = 0;
//                    return ++i;
//                }
//                case 2 : {
//                    break;
//                }
//                case 3 : {
            amountDead = 0;
            CharacteristicsService.upLevel(hero);
            System.out.println("Вы продвинулись на этаж выше!");
            return ++i;
//                }
//            }
        }
        return i;
    }

    public static void openTheDoor(LinkedList<Floor> floors, Monster victim, Hero hero, int levelOfFloor, int idMonster)
            throws IOException, InterruptedException {
        if (floors.get(levelOfFloor).getMonsterMap()[idMonster] != null) {
            victim = floors.get(levelOfFloor).getMonsterMap()[idMonster];
            System.out.println(victim.getNameMonster());
            if(choose(hero, victim)) {
                hero.getCharacteristics().setHealth(100);
                floors.get(levelOfFloor).getMonsterMap()[idMonster] = null;
                amountDead++;
                Magic.setUse(false);
            }
        }
        else{
            System.out.println("Вы убили в этой стороне уже всех монстров");
        }
    }

    public static boolean closeTheDoor(Monster victim){
        if (Fight.isDead(victim)){
            if(MonsterService.isUseItem(victim) && !victim.getItem().getName().equals("Нет"))
                try {
                    MonsterService.takeThisWeapon(victim, hero);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            System.out.println("Вы победили в этой битве!");
            return true;
        }
        System.out.println("Здоровье врага: " + victim.getCharacteristics().getHealth());
        return false;
    }
}
