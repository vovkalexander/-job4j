package ru.job4j.array;

/**
 * FindLoop
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class FindLoop {
    /**
     * indexOf.
     * @param data array.
     * @param el element from array.
     * @return index of element.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
