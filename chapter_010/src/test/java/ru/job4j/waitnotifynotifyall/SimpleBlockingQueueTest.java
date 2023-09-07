package ru.job4j.waitNotifyNotifyAll;
import org.junit.Test;
import ru.job4j.waitNotifyNotifyALL.SimpleBlockingQueue;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;
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
                        try {
                            queue.poll();
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
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
                        try {
                            queue.poll();
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
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
    @Test
    public void whenFetchAllThenGetIt() throws InterruptedException {
        final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
        final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);
        Thread producer = new Thread(
                () -> {
                    IntStream.range(0, 5).forEach(queue::offer);
                }
        );
        Thread consumer = new Thread(
                () -> {
                    while (queue.getQueueSize() != 0 || !Thread.currentThread().isInterrupted()) {
                        try {
                            buffer.add(queue.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        producer.start();
        consumer.start();
        producer.join();
        consumer.interrupt();
        consumer.join();
        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3, 4)));
    }
}
