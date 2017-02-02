package com.fight;

import com.content.Message;
import com.entity.persons.Entity;
import com.entity.persons.ext.Hero;
import com.entity.persons.ext.Monster;
import com.entity.skills.Magic;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Vladislav on 31.01.2017.

 * Класс отвечающий за действия в бою
 */
public class Fight {
    private final static int DEFAULT_HIT_RATE = 60;
    private final static int MODIFIER = 2;

    /**
     * Функция высчитывающая шанс попадания по противнику
     * @param fighter1 - первый противник
     * @param fighter2 - второй противник
     * @return - возвращает истину, если попадание совершено
     */
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

    /**
     * Функция, отвечающая за нанесение урона по противнику.
     * @param fighter1 - первый противник
     * @param fighter2 - второй противник
     */
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

    /**
     * Проверяет, остался ли жив противник после удара по нему.
     * @param fighter1 - противник
     * @return - возвращате истину, если здоровье противника меньше 0
     */
    public static boolean isDead(Entity fighter1){
        return fighter1.getCharacteristics().getHealth() <= 0;
    }

    /**
     * Функция, отвечающая за использование защитной магии во время боя.
     * @param fighter - главный герой
     * @param nameMagic - название магии, которую выбрал персонаж
     * @throws IOException
     */
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

    /**
     * Функция, отвечающая за использование главным героем атакующей магии
     * @param fighter - главный герой
     * @param nameMagic - название используемой магии
     * @throws IOException
     */
    public static void useOffensiveMagic(Entity fighter, String nameMagic) throws IOException {
        Monster monster;
        Hero hero = new Hero();
        if (fighter instanceof Monster){
            monster = (Monster) fighter;
            if (hero.getMagics().containsKey(nameMagic)) {
                Magic magic = hero.getMagics().get(nameMagic);
                implUseMagic(monster, magic);
            }
        }
    }

    /**
     *Функция, отвечающая за использоваие главным герое магии его оружие
     * @param hero - главный герой
     * @param monster - игровой объект, по которому будет совершен удар
     * @throws IOException
     */
    public static void useMagicOfWeapons(Hero hero, Monster monster) throws IOException {
        String nameMagic = hero.getItem().getSkill();
        Magic magic = hero.getMagics().get(nameMagic);
        implUseMagic(monster, magic);
    }

    /**
     *Функция, отвечающая за использоваие главным герое магии
     * @param monster - игровой объект, по которому будет совершен удар
     * @param magic - используемая магия
     */
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
