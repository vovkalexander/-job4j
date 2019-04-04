package ru.job4j.list;
import java.util.ArrayList;
import java.util.List;
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
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}

