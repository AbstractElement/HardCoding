package com.content;

/**
 * Created by Vladislav on 31.01.2017.

 * Интерфейс в котором хранятся сообщения, появляющиеся в ходе игры
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
            "\n6. Бежать" +
            "\n0. Сохранить и выйти";
    public final static String THIRD_CHOOSE_MENU =
            "1. Регенерация " +
            "\n2. Огненный удар " +
            "\n0. Назад";
    public final static String UP_LEVEL_CHARACTERISTICS =
            "1. Сила \n" +
            "2. Ловкость \n" +
            "3. Броня";
    public final static String OVER_MAGIC_MESSAGE =
            "Вы уже использовали заклинание в этой битве, вам необходимо восполнить силы!";
    public final static String WIN_MESSAGE =
            "Поздравляю!!! Вы прошли игру и очистили башню от нечисти!";
    public final static String UP_LEVEL_MESSAGE =
            "Вы убили всех монтстров на этом этаже и можете двигаться дальше." +
                    "\nВам предоставлено 3 очка улучшения характеристик";
    public final static String NO_MAGIC_SKILL = "Ваше снаряжение не имеет магических способностей!";
    public final static String YOU_FLED = "Вам удалось сбежать!";
    public final static String NEXT_FLOOR = "Вы продвинулись на этаж выше!";
    public final static String YOU_KILLED_ALL = "Вы убили в этой стороне уже всех монстров";
    public final static String YOU_WIN_IN_THIS_FIGHT = "Вы победили в этой битве!";
}
