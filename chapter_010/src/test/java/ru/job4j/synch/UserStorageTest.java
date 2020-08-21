package ru.job4j.synch;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * UserStorageTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class UserStorageTest {
    @Test
    public void whenTwoThreadsAlertsOneObject() throws InterruptedException {
        User user1 = new User(1, 100);
        User user2 = new User(1, 120);
        UserStorage storage = new UserStorage();
        storage.add(user1);
        Thread first = new Thread(() -> storage.update(user2));
        Thread second = new Thread(() -> storage.transfer(1, 0, 50));
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(user2.getAmount(), is(70));
    }
}
