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

        setResult(first + second + third);
    }
    /**
     * The  method is overloaded.
     */

    public void subtract(double first, double second, double third) {
        setResult(first - second - third);
    }
    /**
     * The  method is overloaded.
     */

    public void multiple(double first, double second, double third) {
        setResult(first * second * third);
    }
    /**
     * Method, in which calculates values of sin.
     * @param first - double value.
     */

    public void sin(double first) {
        setResult(Math.sin(first));
    }
    /**
     * Method, in which calculates values of cos.
     * @param first - double value.
     */

    public void cos(double first) {
        setResult(Math.cos(first));
    }
    /**
     * Method, in which calculates values of tan.
     * @param first - double value.
     */

    public void tan(double first) {
        setResult(Math.tan(first));
    }
    /**
     * Method, in which calculates values of ctg.
     * @param first - double value.
     */

    public void ctg(double first) {
        setResult(1 / Math.tan(first));
    }
}
