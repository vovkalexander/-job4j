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
          for (Map.Entry<String, Set<String>> entry : user.entrySet()) {
               for (String key : emails.keySet()) {
                    if (entry.getValue().contains(key)) {
                         user.get(entry.getKey()).addAll(user.get(emails.get(key)));
                    }
               }
          }
     }
}









