package ru.job4j.concurrent;
/**
 * Cache.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Cache {
    /**
     * Field - stores link of object Cache.
     */
    private static Cache cache;
    /**
     * The method creates object of Cache.
     * @return object of Cache.
     */

    private synchronized static Cache instOf() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }
}
