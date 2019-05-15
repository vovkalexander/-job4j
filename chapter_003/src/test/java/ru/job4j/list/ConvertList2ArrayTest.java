package ru.job4j.list;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(List.of(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void when9ElementsThen10() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 5);
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
                {9, 0},
        };
        assertThat(result, is(expect));
    }
    @Test
    public void whenConvert6ElementsThenHave6SequentialElements() {
        ConvertList2Array convertList = new ConvertList2Array();
        List<int[]> list = List.of(
        new int[]{1, 2},
        new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(list);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}
