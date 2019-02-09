package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * MergeTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class MergeTest {
    @Test
    public void whenOneArrayWithTwoArrayMergedThennewArray() {
        Merge mergedArray = new Merge();
        int[] a = new int[]{4, 5, 8, 9, 10};
        int[] b = new int[]{1, 2, 5, 7, 12};
        int[] result = mergedArray.sortMerge(a, b);
        int[] expect = new int[]{1, 2, 4, 5, 5, 7, 8, 9, 10, 12};
        assertThat(result, is(expect));
    }
}
