package ru.job4j.tracker;

import java.util.List;

/**
 * StubInput.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * 6 - выйти из трекера.
     */
    private final List<String> value;
    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position = 0;
    /**
     * Конструтор инициализирующий поля.
     * @param value ввод данных.
     */

    public StubInput(final List<String> value) {
        this.value = value;
    }
    /**
     * Метод реализаущий активирующий запрос параметров .
     * @param question - запрос пользователю.
     */

    public String ask(String question) {
        return this.value.get(position++);
    }
    /**
     * Метод реализаущий запрос параметров пользователя, c учетом диапозона меню.
     * @param question - запрос пользователю.
     * @param range - массив соответствующий кол-во пунктов меню.
     */

    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}



