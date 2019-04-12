package ru.job4j.sort;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * UserCompare.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SortUser {
    /**
     * Метод добавляет отсортированых пользователей в список.
     * @param users список пользователей.
     * @return список пользователелей.
     */
    public Set<User> sort (List<User> users) {
        return new TreeSet<User>(users);
    }
}
