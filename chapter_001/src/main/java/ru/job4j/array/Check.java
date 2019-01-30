package ru.job4j.array;
/**
 * Check.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * Method  mono.
     * @param data(array) of boolean elements.
     * @return boolean.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != data[0]) {
                return result;
            }
        }
        result = true;
        return result;
    }
}
