package ru.job4j.sort;
import org.junit.Test;

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
        List<User> users = List.of(
        new User("Tramp", 72),
        new User("Obama", 57),
        new User("Bush", 72));
        SortUser sorter = new SortUser();
        Set<User> result = sorter.sort(users);
        assertThat(result.iterator().next().getName(), is("Obama"));
    }
    @Test
    public void whenOneNameLengthLessTwoThenSortFirst() {
        List<User> users = List.of(
        new User("Tramp", 72),
        new User("Obama", 57),
        new User("Bush", 72));
        SortUser sorter = new SortUser();
        List<User> result = sorter.sortNameLength(users);
        assertThat(result.iterator().next().getName(), is("Bush"));
    }
    @Test
    public void whenOneNameEqualsTwoThenSortByAge() {
        List<User> users = List.of(
        new User("Tramp", 72),
        new User("Obama", 57),
        new User("Bush", 72),
        new User("Bush", 37));
        SortUser sorter = new SortUser();
        List<User> result = sorter.sortByAllFields(users);
        assertThat(result.iterator().next().getName(), is("Bush"));
    }
}
