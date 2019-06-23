package ru.job4j.generic;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Test.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayTest {
    @Before
    public void setUp() {
        SimpleArray<Integer> list = new SimpleArray<>(10);
    }
    @Test
    public void whenAddValueThanReceiveValue() {
        SimpleArray<Integer> list = new SimpleArray<>(10);
        list.add(1);
        assertThat(list.get(0), is(1));
    }
    @Test
    public void whenSetNewValueThanChangeOldToNewValue() {
        SimpleArray<Integer> list = new SimpleArray<>(10);
        list.add(1);
        list.add(0);
        list.set(1,3);
        assertThat(list.get(1), is(3));
    }
    @Test
    public void whenRemoveValueFromArrayThenArrayBecomeshasNotValue() {
        SimpleArray<Integer> list = new SimpleArray<>(10);
        list.add(10);
        list.add(11);
        list.add(12);
        list.remove(1);
        assertThat(list.get(1), is (12));
    }
    @Test
    public void whenIteratorNextthenReturnElementOfArray() {
        SimpleArray<Double> list = new SimpleArray<>(10);
        list.add(3d);
        list.add(2d);
        list.add(5d);
        Iterator it = list.iterator();
        assertThat(list.get(0), is(it.next()));
        assertThat(it.next(), is(2d));
    }
    @Test
    public void whenIteratorHasNextthenArrayReturnsTrue() {
        SimpleArray<Integer> list = new SimpleArray<>(10);
        list.add(7);
        list.add(2);
        list.add(1);
        Iterator it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenIndexOutOfborderThenHapenExeption() {
        SimpleArray<Integer> list = new SimpleArray<>(2);
        list.add(7);
        list.add(2);
        list.add(1);
    }
}