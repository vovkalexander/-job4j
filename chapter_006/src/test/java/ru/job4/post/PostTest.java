package ru.job4.post;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

/**
 * PostTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
class PostTest {
    @Test
    public void testMerge() {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("xxx@ya.ru");
        set1.add("foo@gmail.com");
        set1.add("lol@mail.ru");
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("foo@gmail.com");
        set2.add("ups@pisem.net");
        Set<String> set3 = new LinkedHashSet<>();
        set3.add("xyz@pisem.net");
        set3.add("vasya@pupkin.com");
        Set<String> set4 = new LinkedHashSet<>();
        set4 .add("ups@pisem.net");
        set4 .add("aaa@bbb.ru");
        Set<String> set5 = new LinkedHashSet<>();
        set5.add("xyz@pisem.net");
        Map<String, Set<String>> users = new LinkedHashMap<>();
        users.put("user1",set1);
        users.put("user2",set2);
        users.put("user3",set3);
        users.put("user4",set4);
        users.put("user5",set5);
        Map<String, String> email = new LinkedHashMap<>();
        email.put("xxx@ya.ru","user1");
        email.put("foo@gmail.com","user1");
        email.put("lol@mail.ru","user1");
        email.put("foo@gmail.com","user2");
        email.put("ups@pisem.net","user2");
        email.put("xyz@pisem.net","user3");
        email.put("vasya@pupkin.com","user3");
        email.put("ups@pisem.net","user4");
        email.put("aaa@bbb.ru","user4");
        email.put("xyz@pisem.net","user5");
        Post post = new Post();
        post.merge(users, email);
        assertThat(users.get("user1"), is(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru",
                "ups@pisem.net", "aaa@bbb.ru")));
        assertThat(users.get("user2"), is(Set.of("foo@gmail.com", "ups@pisem.net", "aaa@bbb.ru")));
        assertThat(users.get("user3"), is(Set.of("xyz@pisem.net", "vasya@pupkin.com")));
        assertThat(users.get("user4"), is(Set.of("ups@pisem.net", "aaa@bbb.ru")));
    }
}