package ru.job4j.array;
/**
 * Merge.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Merge {
    /**
     * sortMerge .
     * @param array1, array2 int elements.
     * return Merged array.
     */
    public int[] sortMerge(int[] array1, int[] array2) {
        int[] newArray = new int[array1.length + array2.length];
        int elArr1 = 0;
        int elArr2 = 0;
        int elNewArr = 0;
        while (elArr1 < array1.length && elArr2 < array2.length) {
            if (array1[elArr1] <= array2[elArr2]) {
                newArray[elNewArr++] = array1[elArr1];
                elArr1++;
            } else {
                newArray[elNewArr++] = array2[elArr2];
                elArr2++;
            }
        }
        while (elArr1 < array1.length) {
            newArray[elNewArr++] = array1[elArr1++];
        }
        while (elArr2 < array2.length) {
            newArray[elNewArr++] = array2[elArr2++];
        }
        return newArray;
    }
}


