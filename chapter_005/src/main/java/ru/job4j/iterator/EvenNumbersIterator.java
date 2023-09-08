package ru.job4j.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * EvenNumbersIterator.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class EvenNumbersIterator implements Iterator {
    /**
     * Поле - хранит массив.
     */
    private final int[] numbers;
    /**
     * Поле - хранит счетчик перебора элементов массива.
     */
    private int index = 0;
    /**
     * Конструктор для активации поля.
     * @param numbers массив чисел.
     */

    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }
    /**
     * Метод - проверяет наличие четных чисел в массиве.
     * @return логический вывод.
     */

    @Override
    public boolean hasNext() {
        int i = index;
        while ((i < numbers.length) && (numbers[i] % 2 != 0)) {
            i++;
        }
        return (i < numbers.length);
    }
    /**
     * Метод возращает четное число массива и переводит каретку на одну позицию вперед.
     * @return rst - элемент массиа.
     */

    @Override
    public Object next() {
        while ((index < numbers.length) && (numbers[index] % 2 != 0)) {
            index++;
        }
        if (index == numbers.length) {
            throw new NoSuchElementException();
        }
        return numbers[index++];
    }
}