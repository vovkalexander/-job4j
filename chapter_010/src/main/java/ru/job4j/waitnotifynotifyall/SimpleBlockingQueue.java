package ru.job4j.waitNotifyNotifyALL;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.util.LinkedList;
import java.util.Queue;
/**
 * SimpleBlockingQueue.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();
    @GuardedBy("this")
    private final int maxSize;
    /**
     * Constructor for activation field.
     */
    public SimpleBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
    }
    /**
     * The method adds value to queue.
     * @param value - type of value.
     */

    public void offer(T value)  {
        synchronized (this) {
            while (queue.size() == maxSize) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.queue.add(value);
            notify();
        }
    }
    /**
     * The method returns type of value with removal.
     */

    public T poll() throws InterruptedException {
        synchronized (this) {
            while (this.queue.size() == 0) {
                wait();
            }
            T result = this.queue.poll();
            notify();
            return result;
        }
    }
    /**
     * The method returns queue.
     */

    public synchronized int getQueueSize() {
        return  this.queue.size();
    }
}
