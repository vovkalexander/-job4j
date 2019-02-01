package ru.job4j.array;
/**
 * Matrix.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class Matrix {
    /**
     * Method multiple.
     * @param size of dual array.
     * @return  multiplied array.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (int) Math.multiplyExact((i + 1), (j + 1));
            }
        }
        return table;
    }
}