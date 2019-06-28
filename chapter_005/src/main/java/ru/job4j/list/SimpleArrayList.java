package ru.job4j.list;
/**
 * SimpleArrayList.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayList<E> {
    /**
     * Поле - хранит размер листа.
     */
    private int size;
    /**
     * Поле - хранит ссылку на  объект внутреннего класса.
     */
    private Node<E> first;
    /**
     * Метод вставляет в начало списка данные.
     * @param data - данные.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }
    /**
     * Метод удаляет первый элемент списка.
     */
    public E delete() {
        Node<E> temp = first;
        first = first.next;
        return temp.data;
    }
    /**
     * Метод получения элемента по индексу.
     * @param index - индекс элеммента.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
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
     * Node<E> Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        /**
         * Поле - хранит данные.
         */
        E data;
        /**
         * Поле - хранит ссылку на  объект внутреннего класса.
         */
        Node<E> next;
        /**
         * Конструктор для активации поля .
         * @param data - данные.
         */
        Node(E data) {
            this.data = data;
        }
    }
}
