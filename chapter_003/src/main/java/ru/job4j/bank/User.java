package ru.job4j.bank;
import java.util.Objects;
/**
 * User.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class User implements Comparable<User> {
    /**
     * Поле - хранит имя пользователя.
     */
   private String name;
    /**
     * Поле - хранит пасспорт пользователя.
     */
   private String passport;
    /**
     * Конструктор для активации полей.
     * @param name имя пользователя.
     * @param passport  пасспорт пользователя.
     */

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    /**
     * Метод возвращает имя пользователя.
     * @return имя пользователя.
     */

    public String getName() {
        return name;
    }
    /**
     * Метод возвращает пасспорт пользователя.
     *
     * @return пасспорт пользователя.
     */

    public String getPassport() {
        return passport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User || o == null)) {
            return false;
        }
        User user = (User) o;
        return getName().equals(user.getName()) && getPassport().equals(user.getPassport());
    }

    @Override
    public int compareTo(User one) {
        int rls = this.passport.compareTo(one.getPassport());
        return rls != 0 ? rls : this.name.compareTo(one.getName());
    }
}
