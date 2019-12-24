package ru.job4j.generic;
import java.util.Iterator;
/**
 * SimpleArray.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Поле - хранит массив.
     */
    Object[] objects = new Object[10];
    /**
     * Поле - хранит счетчик индексов.
     */
    int index = 0;
    /**
     * Конструктор для активации поля.
     * @param size  размер массива.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }
    /**
     * Метод - добавляет элемент в массив.
     * @param  value значение.
     */
    public void add(Object value) {
        this.objects[index++] = value;
    }
    /**
     * Метод - возвращает элемент  массива.
     * @param position позиция массива.
     */
    public T get(int position) {
        if (position >= index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) this.objects[position];
    }
    /**
     * Метод - заменяет один элемент массива на другой.
     * @param i позиция массива.
     * @param model новое значение.
     */
    public void  set(int i, T model) {
        if (i >= index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[index] = model;
    }
    /**
     * Метод - удаляет  элемент массива по индексу.
     * @param i ячейка массива.
     */
    public void remove(int i) {
        final int newSize = index - 1;
        if (newSize  > i) {
            System.arraycopy(this.objects, i + 1, objects, i, newSize - i);
            index--;
        }
    }
    /**
     * Метод - возвращает итератор .
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position;
            @Override
            public boolean hasNext() {
                return position < index;
            }
            @Override
            public T next() {
                return (T) objects[position++];
            }
        };
    }
}


