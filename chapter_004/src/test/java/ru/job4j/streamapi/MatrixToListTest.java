package ru.job4j.streamapi;


import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MatrixToListTest {

    @Test
    public void whenInputSquareMatrix() {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> result = MatrixToList.convert(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Assert.assertThat(result.containsAll(expected), is(true));

    }

    @Test
    public void whenInputNoSquareMatrix() {
        Integer[][] matrix = {
                {1},
                {2, 3},
                {4, 5, 6}
        };
        List<Integer> result = MatrixToList.convert(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assert.assertThat(result.containsAll(expected), is(true));
    }
}
