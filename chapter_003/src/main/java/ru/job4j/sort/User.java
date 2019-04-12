package ru.job4j.sort;
/**
 * User.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class User implements Comparable<User> {
    /**
     * Хранит имя пользователя.
     */
    private String name;
    /**
     * Хранит возраст пользователя.
     */
    private int age;

    /**
     * Конструктор для активации полей.
     *
     * @param name имя пользователя.
     * @param age  возраст пользователя.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Метод возвращает имя пользователя.
     *
     * @return имя пользователя.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает возраст пользователя.
     *
     * @return имя пользователя.
     */
    public int getAge() {
        return age;
    }

    public int compareTo(User one) {
        final int rls = Integer.compare(this.getAge(), one.getAge());
        return rls != 0 ? rls : this.name.compareTo(one.name);
    }
}


