package ru.job4j.sort;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortUserTest {
    @Test
    public void whenOneAgeMoreTwoThenSortFirst() {
        List<User> users = new ArrayList<>();
        users.add(new User("Tramp", 72));
        users.add(new User("Obama", 57));
        users.add(new User("Bush", 72));
        SortUser sorter = new SortUser();
        Set<User> result = sorter.sort(users);
        assertThat(result.iterator().next().getName(), is("Obama"));
    }
}
