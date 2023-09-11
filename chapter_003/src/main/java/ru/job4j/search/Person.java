package ru.job4j.search;
/**
 * Person.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Person {
    /**
     * Хранит имя пользователя.
     */
    private String name;
    /**
     * Хранит фамилию пользователя.
     */
    private String surname;
    /**
     * Хранит номер телефона пользователя.
     */
    private String phone;
    /**
     * Хранит адрес пользователя.
     */
    private String address;
    /**
     * Конструктор для активации полей.
     * @param name имя пользователя.
     * @param surname фамилия пользователя.
     * @param phone номер телефона пользователя.
     * @param address адрес пользователя.
     */

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }
    /**
     * Метод возвращает имя пользователя.
     * @return имя пользователя.
     */

    public String getName() {
        return name;
    }
    /**
     * Метод возвращает фамилия пользователя.
     * @return фамилия пользователя.
     */

    public String getSurname() {
        return surname;
    }
    /**
     * Метод возвращает номер телефона пользователя.
     * @return номер телефона пользователя.
     */

    public String getPhone() {
        return phone;
    }
    /**
     * Метод возвращает адрес пользователя.
     * @return адрес пользователя.
     */

    public String getAddress() {
        return address;
    }
}
