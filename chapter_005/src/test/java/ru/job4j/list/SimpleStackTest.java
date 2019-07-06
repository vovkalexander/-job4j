package ru.job4j.list;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleStackTest {
    @Test
    public void whenAddElementAtTheEndThenReturnElementFromTheEnd() {
        SimpleStack<Integer> stack = new SimpleStack<>(new DynamicLinkedList());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }

}