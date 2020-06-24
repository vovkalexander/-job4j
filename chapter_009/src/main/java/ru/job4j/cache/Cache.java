package ru.job4j.cache;
/**
 * Cache - abstract class.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public abstract class Cache {
    /**
     * Method fills up the map by values, as in creating map.
     * @param filename - name of file.
     */
    abstract String getStuff(String filename);
}
