package ru.job4j.set;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
/**
 * SimpleSetTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleSetTest {
    SimpleSet set;
    @Before
    public void setUp() {
        set = new SimpleSet();
        set.add(1);
        set.add(2);
        set.add(1);
    }
    @Test
    public void whenSetAddsElementsThenAddUniqueElements() {
        assertThat(set.list.get(0), is(1));
        assertNull(set.list.get(2));
    }
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorReturnsRepeatedElementThenException() {
        Iterator it = set.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        it.next();
    }
    @Test
    public void whenSetContainsNullElementThenOnlyOneNullElement() {
        SimpleSet set = new SimpleSet();
        set.add(1);
        set.add(null);
        set.add(2);
        assertThat(set.list.get(0), is(1));
        assertThat(set.list.get(2), is(2));
    }
}