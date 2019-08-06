package ru.job4j.tree;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
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
    Node<E> root;
    /**
     * Поле - хранит количество узлов.
     */
    int count = 1;
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
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<Node<E>> queue = new LinkedList<>();
            Queue<Node<E>> line = new LinkedList<>();
            int currentCount;
            @Override
            public boolean hasNext() {
                queue.offer(root);
                while (!queue.isEmpty()) {
                    Node<E> el = queue.poll();
                    if (el != null) {
                        line.offer(el);
                    }
                    for (Node<E> child : el.leaves()) {
                        queue.add(child);
                    }
                }
                currentCount = line.size();
                System.out.println(currentCount);
                return currentCount-- != 0;
            }
            @Override
            public E next() {
                queue.offer(root);
                while (!queue.isEmpty()) {
                    Node<E> el = queue.poll();

                    if (el != null) {
                        line.offer(el);
                    }

                    for (Node<E> child : el.leaves()) {
                        queue.offer(child);
                    }
                }
                return line.poll().getValue();
            }
        };
    }
}