package ru.job4j.streamapi;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;
/**
 * StreamApi.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Streamapi {
    /**
     * Метод преобразует поток в массив с одним элементом.
     * @param lists список чисел.
     * @return преобразованый список с одним элементом.
     */
    public Optional<Integer> stream(List<Integer> lists) {
        UnaryOperator<Integer> unary = x -> x * x;
        return  lists.stream().filter(list -> list % 2 == 0).map(list ->unary.apply(list)).
                reduce((x, y) ->x + y);
    }
}


