package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Vovk Alexander  (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] input = new int[]{15, 5, 33, 4, 2, 12, 7, 8, 3, 1};
        int[] result = bubble.sort(input);
        int[] expect = new int[]{1, 2, 3, 4, 5, 7, 8, 12, 15, 33};
        assertThat(result, is(expect));
    }
}
