package ru.job4j.demonstration;
import ru.job4j.demonstation.EmptyUser;
import ru.job4j.demonstation.User;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;
/**
 * UserTest
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserTest {
    @Test
    public void memoryTestOfEmptyObjectWithoutFields() {
        EmptyUser user = new EmptyUser();
        assertThat(sizeOf(user), is(16L));
    }

    @Test
    public void memoryTest() {
        User user1 = new User();
        User user2 = new User(1, "Carlson");
        User user3 = new User(1, "Winnie the Pooh", "London");
        assertThat(sizeOf(user1), is(24L));
        assertThat(sizeOf(user2), is(72L));
        assertThat(sizeOf(user3), is(128L));
    }

    @Test
    public void whenGCDeleteObjectByItself() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        User user = new User();
        System.setOut(new PrintStream(out));
        user.method(30000);
        assertThat(out.toString().contains("Object has been destroyed"), is(true));
    }

    @Test(expected = OutOfMemoryError.class)
    public void whenHeapIsFull() throws OutOfMemoryError {
        User user = new User();
        user.method(3000000);
    }

}
