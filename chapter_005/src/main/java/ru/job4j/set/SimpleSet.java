package ru.job4j.set;
import ru.job4j.list.DynamicList;
import java.util.Iterator;
/**
 * SimpleSet.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleSet<E> implements Iterable<E> {
    /**
     * Поле - хранит объект класса DynamicList.
     */
    DynamicList<E> list = new DynamicList<>(10);
    /**
     * Метод - уникальный элемент в множества.
     * @param  value значение.
     */
    public void add(E value) {
        if (!list.contains(value)) {
            list.add(value);
        }
    }
    /**
     * Метод - возвращает итератор .
     */
    public Iterator<E> iterator() {
        return list.iterator();
    }
}