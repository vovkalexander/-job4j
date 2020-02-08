package ru.job4j.srp;


import java.util.List;

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
    public Double perform(ExtendedCalc calc, List<Double> list);
}
