package ru.job4j.list;
/**
 * Node.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Node<E> {
    /**
     * Поле - хранит данные.
     */
    private E value;
    /**
     * Поле - хранит ссылку на  объект следующего объкта.
     */
    private Node<E> next;
    /**
     * Конструктор для активации поля .
     * @param value - данные.
     */

    public Node(E value) {
        this.value = value;
    }
    /**
     * Метод проверяет наличие цыкла.
     * @param first - первый объект списка.
     * @return возвращает логическое значение.
     */

    public static boolean  hasCycle(Node first) {
        if (first == null) {
            return false;
        }
        Node slow = first;
        Node fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

