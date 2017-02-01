package com.fight;

import com.content.Message;
import com.entity.Entity;
import com.entity.Hero;
import com.entity.Monster;
import com.skills.Magic;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Vladislav on 31.01.2017.
 */
public class Fight {
    private final static int DEFAULT_HIT_RATE = 60;
    private final static int MODIFIER = 2;

    public static boolean hit(Entity fighter1, Entity fighter2){
        Random random = new Random();
        int hit = random.nextInt(101);
        int hitRate = DEFAULT_HIT_RATE + fighter1.getCharacteristics().getDexterity()*10
                - fighter2.getCharacteristics().getDexterity()*10;
        if (hit < hitRate) {
            System.out.print("Было совершено попадание! ");
            return true;
        }
        else {
            System.out.println("Был совершен промах!");
            return false;
        }
    }

    public static void damage(Entity fighter1, Entity fighter2){
        Random random = new Random();
        int damage = fighter1.getItem().getStrength()*5 + (fighter1.getCharacteristics().getStrength()
                + random.nextInt(MODIFIER)) * 10 - fighter2.getCharacteristics().getArmor();
        if (damage < 0)
            damage = 0;
        int healthOfVictim = fighter2.getCharacteristics().getHealth();
        fighter2.getCharacteristics().setHealth(healthOfVictim - damage);
        System.out.println("Нанесен урон: " + damage);
    }

    public static boolean isDead(Entity fighter1){
        return fighter1.getCharacteristics().getHealth() <= 0;
    }

    public static void useProtectiveMagic(Entity fighter, String nameMagic) throws IOException {
        Hero hero;
        if (fighter instanceof Hero) {
            hero = (Hero) fighter;
            if (hero.getMagics().containsKey(nameMagic)) {
                Magic magic = hero.getMagics().get(nameMagic);
                if (!magic.isUse()) {
                    int health = hero.getCharacteristics().getHealth();
                    if (health > 70)
                        hero.getCharacteristics().setHealth(100);
                    else
                        hero.getCharacteristics().setHealth(health + magic.getHealth());
                    System.out.println("Вы использовали " + nameMagic + " и восстановили 30 очков жизни! Ваше здоровье: " +
                            hero.getCharacteristics().getHealth());
                    Magic.setUse(true);
                } else
                    System.out.println(Message.OVER_MAGIC_MESSAGE);
            }
        }
    }

    public static void useOffensiveMagic(Entity fighter, String nameMagic) throws IOException {
//        Random random = new Random();
        Monster monster;
        Hero hero = new Hero();
        if (fighter instanceof Monster){
            monster = (Monster) fighter;
            if (hero.getMagics().containsKey(nameMagic)) {
                Magic magic = hero.getMagics().get(nameMagic);
//                if (!magic.isUse()) {
//                    int healthOfMonster = monster.getCharacteristics().getHealth();
//                    int strengthOfMonster = monster.getCharacteristics().getStrength();
//                    monster.getCharacteristics().setHealth(healthOfMonster - magic.getHealth() * random.nextInt(20));
//                    monster.getCharacteristics().setStrength(strengthOfMonster - magic.getStrength());
//                    System.out.println("Вы использовали " + nameMagic + ", сила противника уменьшена на "
//                            + magic.getStrength());
//                    Magic.setUse(true);
//                }
//                else
//                    System.out.println(Message.OVER_MAGIC_MESSAGE);
//            }
                implUseMagic(monster, magic);
            }
        }
    }

    public static void useMagicOfWeapons(Hero hero, Monster monster) throws IOException {
        String nameMagic = hero.getItem().getSkill();
        Magic magic = hero.getMagics().get(nameMagic);
        implUseMagic(monster, magic);
    }

    public static void implUseMagic(Monster monster, Magic magic){
        Random random = new Random();
        if (!magic.isUse()) {
            int healthOfMonster = monster.getCharacteristics().getHealth();
            int strengthOfMonster = monster.getCharacteristics().getStrength();
            monster.getCharacteristics().setHealth(healthOfMonster - magic.getHealth() * random.nextInt(20));
            monster.getCharacteristics().setStrength(strengthOfMonster - magic.getStrength());
            System.out.println("Вы использовали " + magic.getNameMagic() + ", сила противника уменьшена на "
                    + magic.getStrength());
            Magic.setUse(true);
        }
        else
            System.out.println(Message.OVER_MAGIC_MESSAGE);
    }
}
