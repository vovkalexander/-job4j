package ru.job4j.concurrent;
import ru.job4j.concurrent.simpleconcurrent.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
/**
 * UserCache.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class UserCache {
    /**
     * Field - stores  object of ConcurrentHashMap.
     */
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();
    /**
     * Field - stores  object of AtomicInteger.
     */
    private final AtomicInteger id = new AtomicInteger();
    /**
     * The method in which adds new object of User's class.
     */

    public void add(User user) {
        users.put(id.incrementAndGet(), User.of(user.getName()));
    }
    /**
     * The method in which looks for object of User's class by and returns.
     * @return  user's object.
     */

    public User findById(int id) {
        return User.of(users.get(id).getName());
    }
    /**
     * The method in which looks for all objects of User's.
     * @return  list of user's object.
     */

    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        users.values().stream().forEach(user -> result.add(User.of(user.getName())));
        return result;
    }
}
