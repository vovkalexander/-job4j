package ru.job4j.waitNotifyNotifyAll;
import org.junit.Test;
import ru.job4j.waitNotifyNotifyALL.SimpleBlockingQueue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * SimpleBlockingQueueTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleBlockingQueueTest {
    @Test
    public void whenTwoThreadsWorkByTurn() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);
        Thread producer = new Thread(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        queue.offer(i);
                    }
                }
        );
        Thread consumer = new Thread(
                () -> {
                    for (int i = 0; i < 3; i++)  {
                        queue.poll();
                        assertThat(queue.getQueueSize(), is(3 - 1 - i));
                    }
                }
        );
        producer.start();
        producer.join();
        consumer.start();
        consumer.join();
        assertThat(queue.getQueueSize(), is(0));
    }

    @Test
    public void whenSecondThreadIsInterrupted() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);
        Thread producer = new Thread(
                () -> {
                    for (int i = 0; i < 3; i++) {
                        queue.offer(i);
                    }
                }
        );
        Thread consumer = new Thread(
                () -> {
                    while (!Thread.currentThread().isInterrupted()) {
                        queue.poll();
                        Thread.currentThread().interrupt();

                    }
                }
        );
        producer.start();
        producer.join();
        consumer.start();
        consumer.join();
        assertThat(queue.getQueueSize(), is(2));
    }
}
