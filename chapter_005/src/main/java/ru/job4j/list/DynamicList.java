package ru.job4j.list;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * DynamicList.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class DynamicList<E> implements Iterable<E> {
    /**
     * Поле - хранит массив.
     */
    private Object[] container;
    /**
     * Поле - хранит счетчик индексов.
     */
    private int index = 0;
    /**
     * Поле - хранит размер массива.
     */
    private int size;
    /**
     * Поле - хранит счетчик изменение структуры массива.
     */
    private int modCount;
    /**
     * Конструктор для активации размера массива.
     * @param size  размер массива.
     */
    public DynamicList(int size) {
        this.size = size;
        this.container = new Object[size];
    }
    /**
     * Метод - добавляет элемент в массив.
     * @param  value значение.
     */
    public void add(E value) {
        ensureCapacity();
        container[index++] = value;
        modCount++;
    }
    /**
     * Метод - увеличивает размер  массива при заполнении.
     */
    private void ensureCapacity(){
        if (index + 1 == size) {
            size *= 2;
            E[] newContainer = (E[])  new Object[size];
            for (int i = 0; i < index; i++) {
                newContainer[i] = (E) container[i];
                container = newContainer;
            }
        }
    }
    /**
     * Метод - возвращает элемент  массива.
     * @param index позиция массива.
     */
    public E get(int index) {
        return (E) container[index];
    }
    /**
     * Метод - возвращает массив.
     */
    public Object[] get() {
        return this.container;
    }
    /**
     * Метод - возвращает итератор .
     */
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int position;
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return position < index;
            }
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[position++];
            }
        };
    }
}


