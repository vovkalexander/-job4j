package ru.job4.post;
import java.util.*;

import static java.util.Collections.disjoint;

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
        List<User> result = new ArrayList<>();
        int index = 0;
        for (Iterator<User> it = list.iterator(); it.hasNext(); index++) {
            User idCurrent = it.next();
            for (int j = index + 1; j < list.size(); j++) {
                User user = list.get(j);
                if (idCurrent.getEmailAdress().removeAll(user.getEmailAdress())) {
                    idCurrent.getEmailAdress().addAll(user.getEmailAdress());
                };
            }
            result.add(idCurrent);
        }
        return result;
    }
}




