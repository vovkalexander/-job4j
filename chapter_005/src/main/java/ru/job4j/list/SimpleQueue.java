package ru.job4j.list;
/**
 * SimpleQueue.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueue<E> {
    /**
     * Поле - хранит ссылку на  объект.
     */
    SimpleStack<E> stack;
    /**
     * Конструктор для активации ссылки.
     * @param stack ссылка на объект.
     */
    public SimpleQueue(SimpleStack<E> stack) {
        this.stack = stack;
    }
    /**
     * Метод - добавляет элемент в список.
     * @param  value значение.
     */
    public void push(E value){
     stack.push(value);
    }
    /**
     * Метод - удаляет элемент из списока и возвращает.
     * @return значение.
     */
    public E poll() {
        return stack.link.deleteFirst();
    }
}
