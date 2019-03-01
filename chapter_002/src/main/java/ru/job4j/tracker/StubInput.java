package ru.job4j.tracker;
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
    private final String[] value;
    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position = 0;
    /**
     * Конструтор инициализирующий поля.
     * @param value ввод данных.
     */
    public StubInput(final String[] value) {
        this.value = value;
    }
    /**
     * Метод реализаущий активирующий запрос параметров .
     * @param question - запрос пользователю.
     */
    public String ask(String question) {
        return this.value[position++];
    }

    public int ask(String question, int[] range) {
        ///throw new UnsupportedOperationException("Unsupported operation");
        return  -1;
    }
}


