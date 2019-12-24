package ru.job4j.list;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * DynamicLinkedList.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class DynamicLinkedList<E> implements Iterable<E> {
    /**
     * Поле - хранит размер массива.
     */
    private int size;
    /**
     * Поле - хранит счетчик изменение структуры массива.
     */
    int modCount;
    /**
     * Поле - хранит ссылку на  объект внутреннего класса.
     */
    private Node<E> first;
    /**
     * Поле - хранит ссылку на  объект внутреннего класса.
     */
    private Node<E> last;
    /**
     * Метод вставляет в конец списка данные.
     * @param data - данные.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        if (first == null) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
        this.size++;
        modCount++;
    }
    /**
     * Метод получения элемента по индексу.
     * @param index - индекс элеммента.
     */
    public E get(int index) {
        Node<E> result = this.last;
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size && index >= 0) {
            for (int i = size - 1; i > index; i--) {
                result = result.previous;
            }
        }
        return result.data;
    }
    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }
    /**
     * Метод удаляет первый элемент коллекции.
     * @return возвращает значение.
     */
    public E deleteFirst() {
        E temp = first.data;
        if (first.next == null) { // Если только один элемент
            first = null;
        } else {
            first.next.previous = null;
            first = first.next;
        }
        size--;
        return temp;
    }
    /**
     * Метод удаляет элемент коллекции.
     * @return возвращает значение.
     */
    public E deleteLast() {
        E temp = last.data;
        if (size >= 2) {
            last.previous.next = null;
            last = last.previous;
            size--;
        } else if (size == 1) {
            first = null;
            last = null;
            size--;
        }
        return temp;
    }

    /**
     * Node<E> Класс предназначен для хранения данных.
     */
    public static class Node<E> {
        /**
         * Поле - хранит данные.
         */
        E data;
        /**
         * Поле - хранит ссылку на  объект следующего объкта.
         */
        Node<E> next;
        /**
         * Поле - хранит ссылку на  объект предыдущего объекта.
         */
        Node<E> previous;

        /**
         * Конструктор для активации поля .
         *
         * @param data - данные.
         */
        Node(E data) {
            this.data = data;
        }
    }
    /**
     * Метод - возвращает итератор .
     */
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;
            Node<E> current = first;
            @Override
            public boolean hasNext() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return current != null;
            }
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = current.data;
                current = current.next;
                return value;
            }
        };
    }
}




