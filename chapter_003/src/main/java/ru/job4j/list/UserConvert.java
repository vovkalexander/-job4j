package ru.job4j.list;
import java.util.HashMap;
import java.util.List;
/**
 * UserConvert.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class UserConvert {
    /**
     * Возвращает коллекцию отображения.
     * @param list список пользователей.
     * @return коллекцию отображения.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        list.stream().forEach((user) -> map.put(user.getId(), user));
        return map;
    }
}























