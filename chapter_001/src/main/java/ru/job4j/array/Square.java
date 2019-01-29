package ru.job4j.array;

/**
 * Square.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * Method calculate.
     * @param bound  integer.
     * @return cell of array.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
        }  return rst;
    }
}