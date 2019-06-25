package ru.job4j.generic;
/**
 * Store - интерфейс.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public interface Store<T extends Base> {
    /**
     * Метод - добавляет объект в массив.
     * @param  model объект.
     */
    void add(T model);
    /**
     * Метод - заменяет объект в массиве по id.
     * @param  id объекта.
     * @param  model новый объект.
     */
    boolean replace(String id, T model);
    /**
     * Метод - заменяет удаляет объект в массиве.
     * @param  id объекта.
     */
    boolean delete(String id);
    /**
     * Метод - находит объект в массиве.
     * @param  id объекта.
     */
    T findById(String id);
}
