package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Tracker.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    List<Item> items = new ArrayList<>();
    /**
     * Указатель ячейки для новой заявки.
     */
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     *
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
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
     * @param id   заявки.
     * return логическое значение.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                result = true;
                items.set(index, item);
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
        for (int index = 0; index < items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                result = true;
                items.remove(index);
            }
        }
        return result;
    }
    /**
     * Находит все заявки .
     * return список заявок(массив).
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        items.stream().forEach(item -> result.add(item));
        return result;
    }
    /**
     * Находит заявку по имени.
     * @param key-имя заявки.
     * return список заявок(массив) с именим key.
     */
    public List<Item> findByName(String key) {
        return items.stream().filter(item -> item.getName().contains(key)).collect(Collectors.toList());
    }
    /**
     * Находит заявку по ID.
     * @param id заявки.
     * return заявку.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
