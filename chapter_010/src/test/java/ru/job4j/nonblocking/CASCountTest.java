package ru.job4j.nonblocking;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
/**
 * CASCountTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class CASCountTest {
    @Test
    public void incrementWithTwoThreads() throws InterruptedException {
        CASCount<Integer> count = new CASCount<>();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++)  {
              count.increment();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++)  {
                count.increment();
            }
        });
        thread1.join();
        assertThat(count.get(), is(10));
        thread2.start();
        thread2.join();
        assertThat(count.get(), is(20));
    }
}
