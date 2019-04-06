package ru.job4j.list;
import java.util.ArrayList;
import java.util.List;

/**
 * ConvertList2Array.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ConvertList2Array {
    /**
     * Метод преобразует список в массив.
     * @param list - список .
     * @param rows - кол-во рядов в двухмерном массиве.
     * @return array - двухмерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells  = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells ];
        int i = 0; int j = 0;
        for (Integer value : list) {
            array[i][j] = value;
            j++;
            if (j > cells - 1) {
                i++;
                j = 0;
            }
        }
        return array;
    }
    /**
     * Метод преобразует список в массив.
     * @param list - список, хранит множество типа целочисленного массива.
     * @return catalogue - список, хранит множество типа Integer.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> catalogue = new ArrayList<>();
        for (int[] ints : list) {
            for (int i : ints) {
                catalogue.add(i);
            }
        }
        return catalogue;
    }
}

