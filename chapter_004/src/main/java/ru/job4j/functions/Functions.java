package ru.job4j.functions;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;
/**
 * Functions.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Functions {
    /**
     * Метод добавляет в список число в диапозоне.
     * @param start число - начальный диапозон.
     * @param finish число - конечный диапозон.
     * @param op - функциональный интерфейс.
     * @return список чисел в диапозоне.
     */
    public List<Double> diapason(double start, double finish, DoubleFunction<Double> op) {
        List<Double> list = new ArrayList<>();
        for (double index = start; index != finish; index++) {
            list.add(op.apply(index));
        }
        return list;
    }
}


