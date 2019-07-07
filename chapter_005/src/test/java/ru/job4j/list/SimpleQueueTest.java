package ru.job4j.list;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;
/**
 * Test.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueueTest {
    @Test
    public void whenAddElementAtTheEndThenReturnElementFromTheBeginning(){
        SimpleQueue<Integer> queue = new SimpleQueue<>(new SimpleStack<>(new DynamicLinkedList<>()));
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }
}