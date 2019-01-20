package ru.job4j.converter;

/**
 * Converter of currency.
 * @author vovk  vovk.ag747@gmail.com
 * @since 20.01.2019
 * @version 1
 */

public class Converter {

    /**
     * Convert rubles to euro.
     * @param value rubles.
     * @return Euro.
     */

    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Convert rubles to dollars.
     * @param value rubles.
     * @return Dollars
     */

    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Convert euro to rubles.
     * @param value euro.
     * @return rubles.
     */

    public int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Convert dollars to rubles.
     * @param value dollars.
     * @return rubles.
     */

    public int dollarToRuble(int value) {
        return value * 60;
    }
}


