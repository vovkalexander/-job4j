package ru.job4j.calculator;

/**
 * Fit.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @since 20.01.2019
 * @version 1
 */
public class Fit {

    /**
     * Perfect weight for men.
     * @param height height.
     * @return perfect Weight.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Perfect weight for women.
     * @param height height.
     * @return perfect Weight.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
