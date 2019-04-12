package ru.job4j.sort;
import java.util.Comparator;
/**
 * UserCompare.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class UserCompare implements Comparator<User> {
    /**
     * Метод сравнивает двух пользователей.
     * @return отсортированных пользователей по возрасту.
     */
    public int compare(User one, User two) {
        return Integer.compare(one.getAge(), two.getAge());
    }
}
