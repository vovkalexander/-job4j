package ru.job4j.array;
/**
 * MatrixCheck.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * Method mono.
     * @param data(array) of boolean elements.
     * @return  boolean.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int x = data.length;
        for (int i = 0; i < x; i++) {
            if (data[0][0] != data[i][i] && data[0][x - 1] != data[0][x - 1 - i]) {
                result = false;
            }
        }
        return result;
    }
}