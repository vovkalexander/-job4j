package ru.job4j.tree;
import java.util.*;
/**
 * Node.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Node<E extends Comparable<E>> {
    /**
     * Поле - хранит массив листьев дерева.
     */
    private final List<Node<E>> children = new ArrayList<>();
    /**
     * Поле - хранит значение узла.
     */
    private final E value;
    /**
     * Конструктор активации значения узла.
     * @param value значение узла.
     */
    public Node(final E value) {
        this.value = value;
    }
    /**
     * Метод - добавляет листья в дерево.
     * @param child - лист дерева
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }
    /**
     * Метод - возвращает массив листьев дерева.
     * @return массив листьев.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }
    /**
     * Метод - спавнивает значение узлов.
     * @return нуль если значения равны.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
    /**
     * Метод - возвращает значение узла.
     * @return значение узла.
     */
    public E getValue() {
        return this.value;
    }
}
