package ru.job4j.calculator;

/**
 * Calculator.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @since 19.01.2019
 * @version 1
 */

public class Calculator {
    /**
     * Contains result variable.
     */

    private double result;

    /**
     * Method add.
     * @param first  1.
     * @param second 1.
     */

    public void add(double first, double second)     {
        this.result = first + second;
    }

    /**
     * Method subtract.
     * @param first  2.
     * @param second 2.
     */

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div.
     * @param first  1.
     * @param second 1.
     */

    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Method multiple.
     * @param first  2.
     * @param second 2.
     */

    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     * Method getResult.
     * @return 2,0,1,4.
     */

        return this.result;
    }
    /**
     * Method getResult.
     * @param digit - variable of Double.
     */
    public void setResult(Double digit) {
        this.result = digit;
    }
}


