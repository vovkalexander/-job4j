package ru.job4j.map;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * SimpleHashMapTest.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class SimpleHashMapTest {
  private   SimpleHashMap<Integer, String> map;

    @Before
    public void setUp() {
        map = new SimpleHashMap<>(10);
    }

    @Test
    public void whenAddDifferentElementsThenReceiveValue() {
        map.insert(23, "Jordan");
        map.insert(7, "Ronaldo");
        assertThat(map.get(7), is("Ronaldo"));
    }

    @Test
    public void whenMapDeletesElementThenTrue() {
        map.insert(23, "Jordan");
        map.insert(7, "Ronaldo");
        assertThat(map.delete(23), is(true));
    }

    @Test
    public void whenMapIsAlmostFullThenDoubleSize() {
        map.insert(23, "Jordan");
        map.insert(33, "Pippen");
        map.insert(10, "Pele");
        map.insert(7, "Ronaldo");
        map.insert(8, "Bryant");
        map.insert(15, "Carter");
        map.insert(21, "Dunkan");
        map.insert(2, "Jonson");
        assertThat(map.getSize(), is(20));
    }

    @Test(expected = NoSuchElementException.class)
    public void when() {
        map.insert(23, "Jordan");
        map.insert(2, "Jonson");
        Iterator<String> it = map.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Jonson"));
        assertThat(it.next(), is("Jordan"));
        it.next();
    }

    @Test
    public void whenElementsHaveTheSameHashCodeThenReplaceValue() {
        assertThat(map.insert(23, "Jordan"), is(true));
        assertThat(map.insert(23, "Lebron"), is(false));
        assertThat(map.get(23), is("Lebron"));
    }
}