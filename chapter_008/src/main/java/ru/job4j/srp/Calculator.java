package ru.job4j.srp;

public class Calculator {
    private double result;

    public void add(double first, double second)     {
        this.result = first + second;
    }

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    public void div(double first, double second) {
        this.result = first / second;
    }

    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public double getResult() {

        return this.result;
    }

    public void setResult(Double digit) {
        this.result = digit;
    }
}
