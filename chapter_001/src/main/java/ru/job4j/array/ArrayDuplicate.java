package ru.job4j.array;
import java.util.Arrays;
/**
 * ArrayDuplicate.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicate {
    /**
     * Method  remove.
     * @param  array of string elements.
     * @return array without duplicate.
     */
    public String[] remove(String[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[n - 1];
                    n--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, n);
    }
}

