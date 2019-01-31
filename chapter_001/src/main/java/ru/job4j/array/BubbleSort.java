package ru.job4j.array;
/**
 * BubbleSort.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * Method  sort.
     * @param  array unsorted .
     * @return  array sorted.
     */
    public int[] sort(int[] array) {
        int temp;
        for (int i = array.length - 1; i > 0; i--)  {
            for (int j = 0; j < i; j++)  {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
