package ru.job4j.tracker;
/**
 * TrackerSingleVer1 - перечисление.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public enum TrackerSingleVer1 {
    /**
     * @param хранит статическую ссылку на объект типа класса .
     */
    instance;
    /**
     * хранит целочисленную переменную .
     */
    private int data;
    /**
     * Метод - геттер.
     * @return data переменную поля.
     */

    public int getData() {
        return data;
    }
    /**
     * Метод - сеттар.
     * @param data переменную поля.
     */

    public void setData(int data) {
        this.data = data;
    }
}
