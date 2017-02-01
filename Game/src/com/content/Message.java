package com.content;

/**
 * Created by Vladislav on 31.01.2017.
 */
public interface Message {
    public final static String FIRST_CHOOSE_MENU =
            "1. Комната слева " +
            "\n2. Комната справа " +
            "\n3. Прямо";
    public final static String SECOND_CHOOSE_MENU =
            "1. Ударить " +
            "\n2. Магия " +
            "\n3. Использовать магию снаряжения" +
            "\n4. Информация о герое " +
            "\n5. Информация о монстре " +
            "\n0. Бежать";
    public final static String THIRD_CHOOSE_MENU =
            "1. Регенерация " +
            "\n2. Огненный удар " +
            "\n0. Назад";
    public final static String UP_LEVEL_CHARACTERISTICS =
            "1. Сила \n" +
            "2. Ловкость \n" +
            "3. Здоровье \n" +
            "4. Броня";
    public final static String OVER_MAGIC_MESSAGE =
            "Вы уже использовали заклинание в этой битве, вам необходимо восполнить силы!";

}
