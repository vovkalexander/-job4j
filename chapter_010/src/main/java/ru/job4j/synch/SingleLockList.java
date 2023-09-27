package ru.job4j.synch;
import ru.job4j.list.DynamicList;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.Iterator;
/**
 * SingleLockList.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    @GuardedBy("this")
    private final DynamicList<T> list = new DynamicList<>(10);
    /**
     * The method adds new value  into list.
     * @param value .
     */

    public synchronized void add(T value) {
        this.list.add(value);
    }

    /**
     * The method returns value from list.
     * @return  value.
     */
    public synchronized T get(int index) {
        return  this.list.get(index);
    }
    /**
     * The method returns  object's Iterator of copied list.
     * @return  object's Iterator.
     */

    @SuppressWarnings("NullableProblems")
    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.list).iterator();
    }
    /**
     * The method turns list into copy.
     * @return  copy.
     */

    public synchronized DynamicList<T> copy(DynamicList<T> array) {
        DynamicList<T> copy = new DynamicList<>(10);
        array.iterator().forEachRemaining(copy::add);
        return copy;
    }
}
