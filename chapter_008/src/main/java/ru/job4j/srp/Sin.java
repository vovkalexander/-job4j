package ru.job4j.srp;
import java.util.List;
/**
 * Sin.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Sin implements Action {
    @Override
    public Double perform(ExtendedCalc calc, List<Double> list) {
        Double rst = calc.getResult();
        if (list.size() == 1) {
          calc.sin(list.get(0));
        } else {
            rst = null;
        }
        return rst;
    }
}
