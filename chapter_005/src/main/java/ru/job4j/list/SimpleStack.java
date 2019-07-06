package ru.job4j.list;
/**
 * SimpleStack.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleStack<E> {
    /**
     * Поле - хранит ссылку на  объект.
     */
    private DynamicLinkedList<E> link;
    /**
     * Конструктор для активации ссылки.
     * @param link  ссылка на объект.
     */
    public SimpleStack(DynamicLinkedList<E> link) {
        this.link = new DynamicLinkedList<E>();
    }
    /**
     * Метод - добавляет элемент в список.
     * @param  value значение.
     */
    public void push(E value) {
        link.add(value);
    }
    /**
     * Метод - удаляет элемент из списока и возвращает.
     * @return значение.
     */
    public E poll() {
        return link.deleteLast();
    }
}
