package ru.job4j.array;
/**
 * Array.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class ArrayChar  {
    /**
     * Contains data(array of char).
     */
    private char[] data;
    /**
     * Constructor ArrayChar.
     * @param line - string variable.
     */

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * startWith .
     * @param prefix-string variable.
     * return boolean.
     */

    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i != value.length; i++) {
            if (this.data[i] != value[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
