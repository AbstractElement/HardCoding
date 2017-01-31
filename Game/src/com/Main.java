package com;

import com.entity.Hero;
import com.entity.Monster;
import com.fight.Fight;
import com.item.Item;
import com.service.createMonsters.CreateMonsters;
import com.service.parse.ParseItemsService;
import com.skills.Magic;
import com.skills.impl.OffensiveMagic;
import com.skills.impl.ProtectiveMagic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Vladislav on 30.01.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ParseItemsService.parseWeapon();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Hero hero = new Hero();
        LinkedList<Monster> monsters = CreateMonsters.createMonster();
//        System.out.println(Fight.hit(hero, monsters.get(0)));
        Monster victim = monsters.get(11);
        System.out.println(victim.getNameMonster());
        while(victim.getCharacteristics().getHealth() > 0 && hero.getCharacteristics().getHealth() > 0){
            System.out.println("1 - ударить; 2 - бежать; 3 - магия");
            int choose = Integer.parseInt(reader.readLine());
            if(choose == 1) {
                if (Fight.hit(hero, victim)) {
                    System.out.print("Вы удачно атакуете! ");
                    Fight.damage(hero, victim);
                    System.out.println("Здоровье врага: " + victim.getCharacteristics().getHealth());
                }
                if (Fight.hit(victim, hero)) {
                    System.out.print("Враг нападает на вас! ");
                    Fight.damage(victim, hero);
                    System.out.println("Ваше здоровье: " + hero.getCharacteristics().getHealth());
                }
            }
            if (choose == 2){
                System.out.println("Вы бежали!");
                break;
            }
            if (choose == 3){
                System.out.println("1 - регенерация; 2 - огн. удар; 3 - морозный удар");
                int chooseMagic = Integer.parseInt(reader.readLine());
                if (chooseMagic == 1) {
                    Fight.useProtectiveMagic(hero, "Регенерация");
                }
                if (chooseMagic == 2) {
                    Fight.useOffensiveMagic(victim, "Огненный удар");
                }
                if (chooseMagic == 3) {
                    Fight.useOffensiveMagic(victim, "Морозный удар");
                }
            }
            Thread.sleep(1000);
        }
    }
}
