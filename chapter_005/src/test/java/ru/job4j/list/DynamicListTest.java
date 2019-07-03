package ru.job4j.list;
import org.junit.Before;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * DynamicListTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class DynamicListTest {
    DynamicList<Integer> list;
    @Before
    public void setUp() {
        list = new DynamicList<>(2);
    }
    @Test
    public void whenSizeOfArrayFullThenThisSizeRisesDoubly() {
        list.add(3);
        list.add(4);
        list.add(5);
        assertThat(list.get().length, is(4));
    }
    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorCreatedAndListChangesThenException() {
        list.add(3);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        list.add(5);
        it.hasNext();
    }
    @Test(expected = NoSuchElementException.class)
    public void whenIterateAfterReturningFinalValueNextThenExсeption() {
        list.add(3);
        list.add(4);
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        it.next();
    }
}