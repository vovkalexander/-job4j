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
     public void merge(Map<String, Set<String>> user, Map<String, String> emails) {
          for (Map.Entry<String, String> entry : emails.entrySet()) {
               for (String key : user.keySet()) {
                    if (user.get(key).contains(entry.getKey())) {
                         user.get(key).addAll(user.get(entry.getValue()));
                    }
               }
          }
     }
}









