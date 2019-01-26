package ru.job4j.loop;

/**
 * Counter
 * @author vovk  vovk.ag747@gmail.com
 * @since 25.01.2019
 * @version 1
 */

public class Counter {
    /**
     * Method add.
     * @param start integer.
     * @param finish integer.
     * @return sum.
     */
    public int add(int start, int finish)  {
        int sum = 0;
        for (start = 0; start <= finish; start++) {

            if (start % 2 == 0) {
                sum = sum + start;
            }
        }     return sum;
    }
}


