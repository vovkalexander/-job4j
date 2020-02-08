package ru.job4j.srp;


import java.util.List;

/**
 * Dividing.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Dividing implements Action {
    @Override
    public Double perform(ExtendedCalc  calc, List<Double> list) {
        Double rst = calc.getResult();
        if (list.size() == 2) {
            calc.div(list.get(0), list.get(1));
        } else {
            rst = null;
        }
        return rst;
    }
}
