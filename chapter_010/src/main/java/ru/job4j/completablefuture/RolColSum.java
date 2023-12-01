package ru.job4j.completablefuture;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RolColSum {
    public static class Sums {
        private int rowSum;
        private int colSum;

        public Sums(int rowSum, int colSum) {
            this.rowSum = rowSum;
            this.colSum = colSum;
        }

        public int getRowSum() {
            return rowSum;
        }

        public void setRowSum(int rowSum) {
            this.rowSum = rowSum;
        }

        public int getColSum() {
            return colSum;
        }

        public void setColSum(int colSum) {
            this.colSum = colSum;
        }

        @Override
        public String toString() {
            return "Sums{"
                    +
                    "rowSum="
                    + rowSum
                    +
                    ", colSum="
                    +
                    colSum
                    +
                    '}';
        }
    }

    public static Sums[] sum(int[][] matrix) {

        Sums[] sum = new Sums[matrix.length];

        int rowSum;
        int columnSum;

        for (int i = 0; i < matrix.length; i++) {
            rowSum = 0;
            columnSum = 0;
            for (int j = 0; j < matrix.length; j++) {

                rowSum += matrix[i][j];
                columnSum += matrix[j][i];

            }

            sum[i] = new Sums(rowSum, columnSum);
        }

        return sum;
    }

    public static Sums[] asyncSum(int[][] matrix) throws ExecutionException, InterruptedException {

        CompletableFuture<Sums[]> array = CompletableFuture.supplyAsync(

                () -> {

                    Sums[] sumAsyn = new Sums[matrix.length];

                    int rowSum;
                    int columnSum;

                    for (int i = 0; i < matrix.length; i++) {
                        rowSum = 0;
                        columnSum = 0;
                        for (int j = 0; j < matrix.length; j++) {

                            rowSum += matrix[i][j];
                            columnSum += matrix[j][i];

                        }

                        sumAsyn[i] = new Sums(rowSum, columnSum);
                    }

                    return sumAsyn;
                }

        );

        return array.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[][] sum = {{8, 2, 13, 4, 3, 17, 27},
                {9, 16, 17, 8, 7, 6, 3},
                {1, 22, 3, 14, 17, 1, 12 },
                {15, 6, 17, 8, 12, 12, 16 },
                {1, 22, 3, 14, 17, 23, 78 },
                {1, 22, 3, 14, 17, 1, 12 },
                {15, 6, 17, 8, 12, 12, 16 }

        };

        System.out.println("start seq");
        Arrays.stream(RolColSum.sum(sum))
                .toList().forEach(System.out::println);

       System.out.println("start asyn");

        Arrays.stream(RolColSum.asyncSum(sum))
                .toList().forEach(System.out::println);

    }
}
