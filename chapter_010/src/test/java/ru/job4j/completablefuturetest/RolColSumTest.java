package ru.job4j.completablefuturetest;

import org.junit.Test;
import ru.job4j.completablefuture.RolColSum;
import ru.job4j.completablefuture.RolColSum.Sums;
import java.util.concurrent.ExecutionException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RolColSumTest {

    @Test
    public void whenSeqMatrix() {
        int[][] matrix = {{11, 21, 31},
                          {41, 51, 61},
                          {71, 81, 91}};

     Sums[] sum  = RolColSum.sum(matrix);

        assertThat(sum[0].getColSum(), is(123));
        assertThat(sum[0].getRowSum(), is(63));
    }

    @Test
    public void whenAsynMatrix() throws ExecutionException, InterruptedException {
        int[][] matrix = {{7, 21, 32},
                          {15, 51, 32},
                          {8, 9, 22}};

        Sums[] sum  = RolColSum.asyncSum(matrix);

        assertThat(sum[1].getColSum(), is(81));
        assertThat(sum[1].getRowSum(), is(98));
    }

}
