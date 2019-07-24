package ru.job4j.map;
import java.util.Calendar;
/**
 * User.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class User {
    /**
     * Поле - хранит имя пользователя.
     */
    private String name;
    /**
     * Поле - хранит кол-во детей у пользователя.
     */
    private int children;
    /**
     * Поле - хранит дату рождения пользователя.
     */
    private Calendar birthday;
    /**
     * Конструктор для активации полей пользователя.
     * @param name имя пользователя.
     * @param children количество детей пользователя.
     * @param birthday дата рождения пользователя.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
    /**
     * Метод возвращает имя пользователя.
     * @return имя пользователя.
     */
    public String getName() {
        return name;
    }
    /**
     * Метод возвращает количество детей пользователя.
     * @return количество детей пользователя.
     */
    public int getChildren() {
        return children;
    }
    /**
     * Метод возвращает дата рождения пользователя.
     * @return дата рождения пользователя.
     */
    public Calendar getBirthday() {
        return birthday;
    }
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday!= null ? birthday.hashCode() : 0);
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return (this.name.equals(user.name) && this.children == user.children && this.birthday.equals(user.birthday));
    }
}
