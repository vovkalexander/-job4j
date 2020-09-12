package ru.job4j.pool;
import ru.job4j.waitNotifyNotifyALL.SimpleBlockingQueue;
import java.util.LinkedList;
import java.util.List;
/**
 * ThreadPool.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class ThreadPool {
    /**
     * Field - stores  object of LinkedList class.
     */
    private final List<Thread> threads = new LinkedList<>();
    /**
     * Field - stores  object of SimpleBlockingQueue class.
     */
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(10);
    /**
     * Constructor for activation threads and adds into list.
     */

    public ThreadPool() {
        int size = Runtime.getRuntime().availableProcessors();
        for (int index = 0; index < size; index ++) {
            threads.add(new Thread(new WorkerThread()));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
    /**
     * The method adds tasks into Blocking queue.
     * @param job - tasks for threads.
     */

    public void work(Runnable job) {
        tasks.offer(job);
    }
    /**
     * The method stops threads.
     */

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
    /**
     * WorkerThread class which implements method run.
     */

    private final class WorkerThread implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                   tasks.poll().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
