package ru.job4j.waitnotifynotifyall;
/**
 * Count.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class CountBarrier {
    /**
     * Field - stores link of object's current class.
     */
    private final Object monitor = this;
    /**
     * Field - stores integer .
     */
    private final int total;
    /**
     * Field - stores integer for increasing.
     */
    private int count = 0;
    /**
     * Constructor for activation field.
     */

    public CountBarrier(final int total) {
        this.total = total;
    }
    /**
     * The method increases count while flag doesn't switch over.
     */

    public void count()  {
        synchronized (monitor) {
            count++;
            monitor.notifyAll();
        }
    }
    /**
     * The method stop thread while conditional is performed and switch over the flag.
     */

    public void await() {
        synchronized (monitor) {
            while (total != count) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        CountBarrier barrier = new CountBarrier(2);
        Thread master = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    barrier.count();
                },
                "Master"
        );
        Thread master1 = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    barrier.count();
                },
                "Master1"
        );
        Thread slave = new Thread(
                () -> {
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " started");
                },
                "Slave"
        );
        master.start();
        slave.start();
        master1.start();
    }
}
