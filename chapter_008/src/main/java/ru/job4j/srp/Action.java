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
     * The abstracted method of interface.
     */
    public Double perform(ExtendedCalc calc, List<Double> list);
}
