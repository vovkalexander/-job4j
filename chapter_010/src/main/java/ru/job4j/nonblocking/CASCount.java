package ru.job4j.nonblocking;
import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;
/**
 * CASCount.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class CASCount<T> {
    /**
     * Field - stores  object of AtomicReference class.
     */
    private final AtomicReference<Integer> count = new AtomicReference<>(0);
    /**
     * The method increases int values.
     */

    public void increment() {
        int current;
        do {
            current = count.get();
        } while ( !count.compareAndSet(current, current + 1));

    }
    /**
     * The method returns int values.
     * @return int value.
     */

    public int get() {
        if (count.get() == null) {
            throw new UnsupportedOperationException("Count is not impl.");
        }
        return count.get();
    }
}
