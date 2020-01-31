package ru.job4j.srp;
import ru.job4j.calculator.Calculator;
import java.util.List;
import java.util.Scanner;
/**
 * Action.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public interface Action {
    /**
     * Field - store regular expression limits inputting parameter.
     */
    String REGEX = "[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]?[\\d]|r";
    /**
     * The abstracted method of interface.
     */
    public Double operation(Calculator calc, List<Double> list);
}
