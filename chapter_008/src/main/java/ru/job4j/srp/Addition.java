package ru.job4j.srp;

import ru.job4j.srp.Action;
import ru.job4j.srp.ExtendedCalc;

import java.util.List;

/**
 * Addition.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Addition implements Action {
    @Override
    public Double perform(ExtendedCalc  calc, List<Double> list) {
        Double rst = calc.getResult();
        if (list.size() == 2) {
            calc.add(list.get(0), list.get(1));
        } else {
            rst = null;
        }
        return rst;
    }
}