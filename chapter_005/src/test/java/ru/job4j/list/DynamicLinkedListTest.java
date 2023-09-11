package ru.job4j.list;
import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * DynamicLinkedListTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class DynamicLinkedListTest {
    @Before
    public void setUp() {
        DynamicLinkedList list = new DynamicLinkedList();
    }

    @Test
    public void whenAddElementThenElementAddsAtEndList() {
        DynamicLinkedList list = new DynamicLinkedList();
        list.add(3);
        list.add(4);
        assertThat(list.get(1), is(4));
    }

    @Test
    public void whenIterateThenListReturnsFinalValue() {
        DynamicLinkedList list = new DynamicLinkedList();
        list.add(3);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorCreatedAndListChangesThenException() {
        DynamicLinkedList list = new DynamicLinkedList();
        list.add(3);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        assertThat(it.next(), is(3));
        list.add(5);
        assertThat(it.next(), is(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void when() {
        DynamicLinkedList list = new DynamicLinkedList();
        list.add(3);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        it.next();
    }

}