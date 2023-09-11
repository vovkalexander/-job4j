package ru.job4j.tree;
import java.util.Optional;
/**
 * SimpleTree - интерфейс
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Метод - добавляет узел в дерево.
     * @param parent - корневой узел.
     * @param child - листья дерева
     * @return логический вывод.
     */
    boolean add(E parent, E child);
    /**
     * Метод - находит узел по значению в дереве.
     * @param value - значение узла.
     * @return узел дерева.
     */

    Optional<Node<E>> findBy(E value);
}
