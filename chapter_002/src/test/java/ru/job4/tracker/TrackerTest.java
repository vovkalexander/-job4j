package ru.job4.tracker;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(next);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteItemThenTreckerDeleteItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        Item next = new Item("test2", "testDescription", 1234L);
        tracker.add(previous);
        tracker.add(next);
        tracker.delete(previous.getId());
        assertThat(tracker.findById(previous.getId()), is(nullValue()));
    }
    @Test
    public void whenFindAllItemsThenTrackerFindsAllItems() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        Item next = new Item("test2", "testDescription", 1234L);
        tracker.add(previous);
        tracker.add(next);
        next.setId(previous.getId());
        List<Item> array = Arrays.asList(previous, next);
        assertThat(tracker.findAll(), is(array));
    }
    @Test
    public void whenFindByNameThenTrackerFindsItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        Item next = new Item("test2", "testDescription", 1234L);
        tracker.add(previous);
        tracker.add(next);
        assertThat(tracker.findByName("test2"), is(Arrays.asList(next)));
    }
    @Test
    public void whenFindByIdThenTrackerFindsItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}
