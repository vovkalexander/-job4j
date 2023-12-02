package ru.job4j.completablefuture;

import java.util.Objects;

public class Sums {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sums sums)) {
            return false;
        }

        return rowSum == sums.rowSum && colSum == sums.colSum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowSum, colSum);
    }
}
