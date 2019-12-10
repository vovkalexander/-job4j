package ru.job4.post;
import java.util.*;
/**
 * Post.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Post {
    /**
     * Метод - выполняющий слияние пользователей.
     * @param list- список пользователей.
     * @return list -список пользователей объединенных e-mails.
     */
    public List<User> merge(List<User> list) {
        Queue<User> q = new LinkedList<>(list);
        while (!q.isEmpty()) {
            User s = q.poll();
            Iterator<User> it = q.iterator();
            while (it.hasNext()) {
                s.getEmailAdress().addAll(it.next().getEmailAdress());
            }
        }
        return list;
    }
}




