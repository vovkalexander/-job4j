package ru.job4j.srp;

import java.util.List;
/**
 * TripleAdditional.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class TripleAdditional implements Action {
    @Override
    public Double perform(ExtendedCalc  calc, List<Double> list) {
        Double rst = calc.getResult();
        if (list.size() == 3) {
            calc.add(list.get(0), list.get(1), list.get(2));
        } else {
            rst = null;
        }
        return rst;
    }
}
