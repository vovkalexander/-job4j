package ru.job4j.nonblocking;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;
/**
 * CacheNonBlockTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class CacheNonBlockTest {
    @Test
    public void whenThrowException() throws InterruptedException {
        CacheNonBlock cache = new CacheNonBlock();
        cache.add(new Base(1, 1));
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread1 = new Thread(
                () -> {
                    try {
                        cache.update(new Base(1, 2));
                    } catch (OptimisticException op) {
                        ex.set(op);
                    }
                });

        Thread thread2 = new Thread(
                () -> {
                    try {
                        cache.update(new Base(1, 2));
                    } catch (OptimisticException op) {
                        ex.set(op);
                    }
                });
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        Assert.assertThat(ex.get().getMessage(), is("The versions are inconsistent"));
    }
}
