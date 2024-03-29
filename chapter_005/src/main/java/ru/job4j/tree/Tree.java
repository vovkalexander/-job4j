package ru.job4j.tree;
import java.util.*;
/**
 * Tree.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Поле - хранит начальный узел дерева.
     */
   private Node<E> root;
    /**
     * Поле - хранит количество узлов.
     */
    private int count = 1;
    /**
     * Конструктор для корневого узла с значением.
     * @param value значение.
     */

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> newNode = findBy(parent);
        if (newNode.isPresent()) {
            newNode.get().add(new Node<>(child));
            count++;
            return true;
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }
    /**
     * Метод - проверяет наличие бинарного дерева.
     * @return логический вывод.
     */

    public boolean isBinary() {
        NodeItr it = new NodeItr();
        while (it.hasNext()) {
            Node<E> node = it.next();
            if (node.leaves().size() > 2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
         private Queue<Node<E>> queue = new LinkedList<>(Collections.singletonList(root));
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> poll = queue.poll();
                queue.addAll(poll.leaves());
                return poll.getValue();
            }

        };
    }
    /**
     * NodeItr - внутренний класс (возвращающий узел в next)
     * @author Vovk Alexander  vovk.ag747@gmail.com
     * @version $Id$
     * @since 0.1
     */

    private class NodeItr implements Iterator<Node<E>> {
        private Queue<Node<E>> queue = new LinkedList<>(Collections.singletonList(root));

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Node<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<E> poll = queue.poll();
            queue.addAll(poll.leaves());
            return poll;
        }
    }
}
