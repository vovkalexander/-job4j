package ru.job4j.iterator;
import java.util.Iterator;
/**
 * MatrixIterator.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class MatrixIterator implements Iterator {
    /**
     * Поле - хранит двумерный массив.
     */
    private final int[][] values;
    /**
     * Поле - хранит счетчик по строке массива.
     */
    private int row = 0;
    /**
     * Поле - хранит счетчик по столбцу массива.
     */
    private int cell = 0;
    /**
     * Конструктор для активации поля.
     * @param values двумерный массив.
     */
    public MatrixIterator(final int[][] values) {
        this.values = values;
    }
    /**
     * Метод - проверяет наличие элементов в массиве.
     * @return логический вывод.
     */
    public boolean hasNext() {
        return row < values.length && cell < values[row].length;
    }
    /**
     * Метод возращает элемент массива и переводит каретку на одну позицию вперед.
     * @return rst - элемент массиа.
     */
    public Object next() {
        int rst;
        if (values[row].length == cell + 1) {
            rst = values[row][cell];
            cell = 0;
            row++;
        } else {
            rst = values[row][cell];
            cell++;
        }
        return rst;
    }
}