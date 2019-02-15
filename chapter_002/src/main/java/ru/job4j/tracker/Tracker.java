package ru.job4j.tracker;
import java.util.*;
/**
 * Tracker.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class    Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Удаляет заменяет заявку.
     * @param item заявка.
     * @param id заявки.
     * return логическое значение.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                result = true;
                this.items[index] = item;
                break;
            }
        }
        return result;
    }
    /**
     * Удаляет заявку.
     * @param id заявки.
     * return логическое значение.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != position; index++) {
            if (this.items[index].getId().equals(id)) {
                result = true;
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
                break;
            }
        }
        return result;
    }
    /**
     * Находит все заявки .
     * return список заявок(массив).
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return Arrays.copyOf(result, result.length);
    }
    /**
     * Находит заявку по имени.
     * @param key-имя заявки.
     * return список заявок(массив) с именим key.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int bound = 0;
        for (int index = 0; index != position; index++) {
            if (items[index].getName().equals(key)) {
                result[bound++] =this.items[index];
            }
        }
        return Arrays.copyOf(result, bound);
    }
    /**
     * Находит заявку по ID.
     * @param  id заявки.
     * return заявку.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item: items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
