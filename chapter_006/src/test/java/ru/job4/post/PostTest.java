package ru.job4.post;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
        List<User> userlist = List.of(new User(set1), new User(set2), new User(set3), new User(set4), new User(set5));
        Post post = new Post();
        post.merge(userlist);
        assertThat(userlist.get(0).getEmailAdress(), is(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru",
                "ups@pisem.net", "aaa@bbb.ru")));
        assertThat(userlist.get(1).getEmailAdress(), is(Set.of("foo@gmail.com", "ups@pisem.net", "aaa@bbb.ru")));
        assertThat(userlist.get(2).getEmailAdress(), is(Set.of("xyz@pisem.net", "vasya@pupkin.com")));
        assertThat(userlist.get(3).getEmailAdress(), is(Set.of("ups@pisem.net", "aaa@bbb.ru")));
    }
}