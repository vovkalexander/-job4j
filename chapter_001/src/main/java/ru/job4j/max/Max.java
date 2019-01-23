package ru.job4j.max;

/**
 * Max.
 * @author vovk  vovk.ag747@gmail.com
 * @since 23.01.2019
 * @version 1
 */


public class Max {
    /**
     * Method max.
     * @param first integer.
     * @param second integer.
     * @return maximum
     */

    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Method max.
     * @param first integer.
     * @param second integer.
     * @param third integer.
     * @return maximum
     */

    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        return this.max(third,temp);
    }

}
