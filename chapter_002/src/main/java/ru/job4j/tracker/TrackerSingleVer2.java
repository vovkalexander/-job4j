package ru.job4j.tracker;
/**
 * TrackerSingleVer2.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleVer2 {
    /**
     * @param хранит статическую ссылку на объект типа класса .
     */
    private static TrackerSingleVer2 instance;
    /**
     * Конструктор - закрытого доступа.
     */
    private TrackerSingleVer2() {
    }
    /**
     * Метод - статический.
     * @return instance-статическую ссылку на объект типа класса
     */
    public static TrackerSingleVer2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingleVer2();
        }
        return instance;
    }
}

