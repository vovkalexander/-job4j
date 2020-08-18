package ru.job4j.synch;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
/**
 * Count.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class Count {
    /**
     * Field - stores link of integer.
     */
    @GuardedBy("this")
    private int value;
    /**
     * The method increases field's values.
     */

    public synchronized void increment() {
        this.value++;
    }
    /**
     * The method returns field's values.
     * @return integer
     */
    
    public synchronized   int get() {
        return this.value;
    }
}
