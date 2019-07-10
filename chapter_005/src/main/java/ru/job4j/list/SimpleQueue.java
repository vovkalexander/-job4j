package ru.job4j.list;
/**
 * SimpleQueue.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueue<E> {
    /**
     * Поле - хранит объект класса stack
     */
   private SimpleStack<E> inner = new SimpleStack<E>(new DynamicLinkedList<>());
    /**
     * Поле - хранит объект класса stack
     */
   private SimpleStack<E> external = new SimpleStack<E>(new DynamicLinkedList<>());
    /**
     * Метод - добавляет элемент в очерьдь.
     * @param value значение.
     */
    public void push(E value) {
        inner.push(value);
    }
    /**
     * Метод - удаляет элемент из списока и возвращает его.
     * @return значение.
     */
    public E poll() {
        while (!inner.isEmpty()) {
            external.push(inner.poll());
        }
        return external.poll();
    }
}
