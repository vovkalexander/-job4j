package ru.job4j.array;
/**
 * Turn.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class Turn {
    /**
     * Method  back.
     * @param array of int elements.
     * @return turn array.
     */
    public int[] back(int[] array) {
        int x = array.length;
        int temp;
        for (int i = 0; i < x / 2; i++) {
            temp = array[x - i - 1];
            array[x - i - 1] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
