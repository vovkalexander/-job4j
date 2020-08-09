package ru.job4j.concurrent;
/**
 * DCLSingleton.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class DCLSingleton {
    /**
     * Field - stores link of object DCLSingleton.
     */
    private volatile static DCLSingleton inst;
    /**
     * Private Constructor for creating single sample of object.
     */

    private DCLSingleton() {
    }
    /**
     * The method creates object of Cache.
     * @return object of Cache.
     */

    public static DCLSingleton instOf() {
        if (inst == null) {
            synchronized (DCLSingleton.class) {
                if (inst == null) {
                    inst = new DCLSingleton();
                }
            }
        }
        return inst;
    }
}
