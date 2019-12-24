package ru.job4j.map;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * SimpleHashMap.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleHashMap<K, V> implements Iterable<V>  {
    /**
     * Поле - хранит массив.
     */
    private  Entry<K, V>[] table;
    /**
     * Поле - хранит размер массива.
     */
    private int size;
    /**
     * Поле - хранит идекс массива.
     */
    private int index;
    /**
     * Поле - хранит счетчик индексов.
     */
    private int count;
    /**
     * Поле - хранит счетчик изменение структуры массива.
     */
    private int modCount;
    /**
     * Поле - хранит степень заполнение массива.
     */
    private float loadFactor = 0.6f;
    /**
     * Конструктор для активации размера массива.
     * @param size  размер массива.
     */
    public SimpleHashMap(int size) {
        this.size = size;
        this.table = new Entry[size];
    }
    /**
     * Метод - добавляет объект в массив.
     * @param key - ключ объекта.
     * @param value - значение.
     * @return логический вывод.
     */
    public boolean insert(K key, V value) {
        if (loadFactor <= (float) count / size) {
            increaseCapacity();
        }
        index = hash(key);
        Entry<K, V> element = this.table[index];
        if (element == null) {
            this.table[index] = new Entry<>(key, value);
            count++;
            modCount++;
            return true;
        } else {
            if (key.equals(table[index].key)) {
                V old = element.value;
                element.value = value;
            }
        }
        return  false;
    }
    /**
     * Метод - рассчитывает индекс масива.
     * @param key - ключ объекта.
     * @return int - число.
     */
    private int hash(Object key) {
        return  key.hashCode() % size;
    }
    /**
     * Метод - увеличивает размер  массива при заполнении.
     */
    private void increaseCapacity() {
        this.size = this.size * 2;
        Entry<K, V>[] newTable = new Entry[this.size];
        for (Entry<K, V> data : this.table) {
            if (data != null) {
                int i = hash((K) data.key);
                newTable[i] = data;
            }
        }
        this.table = newTable;
    }
    /**
     * Метод - возвращает значение по ключу.
     * @param key - ключ объекта.
     * @return value - значение.
     */
    public V get(K key) {
        int i = hash(key);
        return (this.table[i] != null && key.equals(this.table[i].key) ? this.table[i].value : null);
    }
    /**
     * Метод - удаляет объект по ключу.
     * @param key - ключ объекта.
     * @return логический ввывод.
     */
    public boolean delete(K key) {
        index = hash(key);
        if (this.table[index] != null && key.equals(this.table[index].key)) {
            this.table[index] = null;
            count--;
            return true;
        }
        return false;
    }
    /**
     * Метод - возвращает размер массива.
     * @return размер массива.
     */
    public int getSize() {
        return size;
    }
    /**
     * Метод - возвращает итератор .
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int position;
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (position < table.length && table[position] == null) {
                    position++;
                }
                return position < table.length;
            }
            @Override
            public V next() {
                if (hasNext()) {
                    return table[this.position++].value;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
    /**
     * Entry<K,V> - внутренний класc
     * @author Vovk Alexander  vovk.ag747@gmail.com
     * @version $Id$
     * @since 0.1
     */
   private class Entry<K, V> {
        /**
         * Поле - хранит массив.
         */
        K key;
        /**
         * Поле - хранит массив.
         */
        V value;
        /**
         * Конструктор для активации полей.
         * @param key  ключ объекта.
         * @param value - значение объекта.
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
