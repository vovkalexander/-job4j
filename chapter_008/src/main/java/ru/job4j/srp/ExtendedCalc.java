package ru.job4j.srp;
import ru.job4j.calculator.Calculator;
/**
 * ExtendedCalc.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ExtendedCalc extends Calculator {
    /**
     * The  method is overloaded.
     */
    public void add(double first, double second, double third) {
        this.result = first + second + third;
    }
    /**
     * The  method is overloaded.
     */
    public void subtract(double first, double second, double third) {
        this.result = first - second - third;
    }
    /**
     * The  method is overloaded.
     */
    public void multiple(double first, double second, double third) {
        this.result = first * second * third;
    }
}
