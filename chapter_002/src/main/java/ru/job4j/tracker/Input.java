package ru.job4j.tracker;

import java.util.List;

/**
 * Input.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    /**
     * Метод абстрактный ask.
     * @param question - запрос.
     */
    String ask(String question);
    /**
     * Метод абстрактный ask.
     * @param question - запрос.
     * @param range - массив соответствующий кол-во пунктов меню.
     */
    int ask(String question, List<Integer> range);
}
