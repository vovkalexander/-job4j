package ru.job4j.sort;
import java.util.Comparator;
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
    /**
     * Метод  сортирует пользователей по длине имени.
     * @param users список пользователей.
     * @return список пользователелей .
     */
    public List<User> sortNameLength (List<User> users ) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return  users;
    }
    /**
     * Метод  сортирует пользователей по длине имени и по возрасту.
     * @param users список пользователей.
     * @return список пользователелей .
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int rls = Integer.compare(o1.getName().length(),(o2.getName().length()));
                return rls != 0 ? rls : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return users;
    }
}
