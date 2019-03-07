package ru.job4j.tracker;
/**
 * TrackerSingleVer3.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleVer3 {
    /**
     * @param хранит статическую ссылку на объект типа класса .
     */
    private static final TrackerSingleVer3 instance = new TrackerSingleVer3();
    /**
     * Конструктор - закрытого доступа.
     */
    private TrackerSingleVer3() {
    }
    /**
     * Метод - статический.
     * @return instance-статическую ссылку на объект типа класса
     */
    public static TrackerSingleVer3 getInstance() {
        return instance;
    }
}
