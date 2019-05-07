package ru.job4j.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  ConvertMatrix2List.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ConvertMatrix2List {
    /**
     * Метод преобразует двумерный массив в список.
     * @param array - двумерный массив.
     * @return list - коллекция (список).
     */
    public List<Integer> toList(int[][] array) {
        return  Arrays.stream(array).flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList());
    }
}

