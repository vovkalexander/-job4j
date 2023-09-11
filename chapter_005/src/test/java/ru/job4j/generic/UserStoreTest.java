package ru.job4j.generic;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class UserStoreTest {
    private UserStore use;

    @Before
    public void setUp() {
        use = new UserStore(3);
    }

    @Test
    public void whenFindByIdthenReturnValueById() {
        User user1 = new User("1");
        User user2 = new User("2");
        use.add(user1);
        use.add(user2);
        assertThat(use.findById("2"), is(user2));
    }

    @Test
    public void whenReplaceByIdElementThenReturnNewElemet() {
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        use.add(user1);
        use.add(user2);
        use.replace("1", user3);
        assertThat(use.findById("3"), is(user3));
    }

    @Test
    public void whenDeleteByIdThenElementDoesNotExist() {
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        use.add(user1);
        use.add(user2);
        use.add(user3);
        assertThat(use.delete("2"), is(true));
        assertNull(use.findById("2"));
    }
}