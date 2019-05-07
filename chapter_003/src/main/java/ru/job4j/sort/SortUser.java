package ru.job4j.sort;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * UserCompare.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SortUser {
    /**
     * Метод добавляет отсортированых пользователей в список.
     *
     * @param users список пользователей.
     * @return список пользователелей.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<User>(users);
    }

    /**
     * Метод  сортирует пользователей по длине имени.
     *
     * @param users список пользователей.
     * @return список пользователелей .
     */
    public List<User> sortNameLength(List<User> users) {
        return users.stream().sorted((o1, o2) -> Integer.compare(o1.getName().length(), o2.getName().length())
        ).collect(Collectors.toList());
    }

    /**
     * Метод  сортирует пользователей по длине имени и по возрасту.
     *
     * @param users список пользователей.
     * @return список пользователелей .
     */
    public List<User> sortByAllFields(List<User> users) {

        return users.stream().sorted(Comparator.comparing(User::getName).
                thenComparing(Comparator.comparing(User::getAge))).collect(Collectors.toList());
    }
}
