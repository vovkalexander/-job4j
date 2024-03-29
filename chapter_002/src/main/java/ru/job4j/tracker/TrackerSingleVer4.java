package ru.job4j.tracker;
/**
 * TrackerSingleVer4.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleVer4 {
    /**
     * Хранит статическую переменную.
     */
    private  static int sum = 0;

    /**
     * Конструктор - закрытого доступа.
     */
    private  TrackerSingleVer4()    {
        sum++;
    }
    /**
     * Метод - статический.
     * @return ourInstance-статическую ссылку на объект типа внешнего класса.
     */

    public static TrackerSingleVer4 getInstance() {
        return Holder.OUREXAMPLE;
    }
    /**
     *  Класс(статический)- хранит статическую ссылку на объект типа внешнего класса.
     */

    public static int getSum() {
        return sum;
    }

    private static final class Holder {
        private static final TrackerSingleVer4 OUREXAMPLE = new TrackerSingleVer4();
    }
}
