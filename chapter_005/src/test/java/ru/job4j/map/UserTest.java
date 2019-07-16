package ru.job4j.map;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * UserTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class UserTest {
    @Test
    public void whenInstallSameObjectsWithDefaultHashCodeThenReceiveDifferentObjects() {
        User user1 = new User("Kuzma",2, new GregorianCalendar(2000, Calendar.JANUARY , 1));
        User user2 = new User("Kuzma",2, new GregorianCalendar(2000, Calendar.JANUARY , 1));
        Map<User, Object> map = new HashMap<>();
        map.put(user1,"first");
        map.put(user2,"second");
        assertThat(user1.hashCode() == user2.hashCode(), is (true));
        assertThat(user1.equals(user2), is (true));
        assertThat(map.size(), is(1));
    }
}