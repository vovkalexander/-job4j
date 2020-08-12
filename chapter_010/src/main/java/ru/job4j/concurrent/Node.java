package ru.job4j.concurrent;
import net.jcip.annotations.Immutable;
/**
 * Node.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
@Immutable
public class Node<T> {
    /**
     * Field - stores link of object Node.
     */
    private final Node<T> next;
    /**
     * Field - stores link of object Type.
     */
    private final T value;
    /**
     * Constructor for activation fields.
     */

    public Node(Node<T> next, T value) {
        this.next = next;
        this.value =  value;
    }
    /**
     * Methods returns object of Node class.
     */

    public Node<T> getNext() {
        return this.next;
    }
    /**
     * Methods returns value of Type.
     */

    public T getValue() {
        return value;
    }
}
