package ru.job4j.srp;
import ru.job4j.calculator.Calculator;
import java.util.List;
/**
 * Subtracting.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Subtracting implements Action {
    @Override
    public Double operation(Calculator calc, List<Double> list) {
        Double rst = calc.getResult();
        if (list.size() == 2) {
            calc.subtract(list.get(0), list.get(1));
        } else {
            rst = null;
        }
        return rst;
    }
}
