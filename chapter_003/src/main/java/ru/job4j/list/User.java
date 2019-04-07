package ru.job4j.list;
/**
 * User.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class User {
    /**
     * Хранит номер пользователя.
     */
    private int id;
    /**
     * Хранит имя пользователя.
     */
    private String name;
    /**
     * Хранит место проживание.
     */
    private String city;
    /**
     * Конструктор для активации полей.
     * @param id номер пользователя.
     * @param name имя пользователя.
     * @param city место проживание пользователя.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    /**
     * Метод возвращает номер пользователя.
     * @return номер пользователя.
     */
    public int getId() {
        return id;
    }
    /**
     * Метод возвращает имя пользователя.
     * @return имя пользователя.
     */
    public String getName() {
        return name;
    }
    /**
     * Метод возвращает место проживание пользователя .
     * @return место проживание пользователя.
     */
    public String getCity() {
        return city;
    }
}

