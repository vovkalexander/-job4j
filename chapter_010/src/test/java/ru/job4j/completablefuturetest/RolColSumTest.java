package ru.job4j.completablefuturetest;

import org.junit.Test;
import ru.job4j.completablefuture.RolColSum;
import ru.job4j.completablefuture.Sums;
import java.util.concurrent.ExecutionException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RolColSumTest {
    @Test
    public void whenSeqMatrix() {
        int[][] matrix = {{11, 21, 31},
                          {41, 51, 61},
                          {71, 81, 91}};

        Sums[] expected = {
                new Sums(63, 123),
                new Sums(153, 153),
                new Sums(243, 183)

        };
        assertThat(RolColSum.sum(matrix), is(expected));

    }
    @Test
    public void whenAsynMatrix() throws ExecutionException, InterruptedException {
        int[][] matrix = {{7, 21, 32},
                          {15, 51, 32},
                          {8, 9, 22}};
        Sums[] expected = {
                new Sums(60, 30),
                new Sums(98, 81),
                new Sums(39, 86)

        };
        assertThat(RolColSum.asyncSum(matrix), is(expected));
    }
}
