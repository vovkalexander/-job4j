package ru.job4j.loop;
/**
 * Factorial.
 * @author vovk  vovk.ag747@gmail.com
 * @since 25.01.2019
 * @version 1
 */

public class Factorial {
    /**
     * Method calc.
     * @param n integer.
     * @return result.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
