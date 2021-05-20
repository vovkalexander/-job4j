package ru.job4.tracker;

import org.junit.Test;
import ru.job4j.tracker.HbmTracker;
import ru.job4j.tracker.Item;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

import java.util.List;

public class HbmTrackerTest {
    final HbmTracker hbmTracker = new HbmTracker();

    @Test
    public void whenAddItem() {
        Item item = new Item("item1", "itemDescription");
        hbmTracker.add(item);
        List<Item> items = hbmTracker.findAll();
        assertThat(items.size(), is(1));
        assertThat(items.get(0).getIdy(), is(1));
        assertThat(items.get(0).getDescription(), is("itemDescription"));
    }

    @Test
    public void whenReplaceItemId() {
        Item first = new Item("first");
        Item second = new Item("second");
        hbmTracker.add(first);
        hbmTracker.add(second);
        second.setIdy(first.getIdy());
        hbmTracker.replace(String.valueOf(first.getIdy()), second);
        assertThat(hbmTracker.findById(String.valueOf(first.getIdy())).getName(), is("second"));
    }

    @Test
    public void whenDeleteItem() {
        Item first = new Item("first");
        hbmTracker.add(first);
        hbmTracker.delete(String.valueOf(first.getIdy()));
        assertThat(hbmTracker.findById(String.valueOf(first.getIdy())), is(nullValue()));
    }

    @Test
    public void whenFindItemsByName() {
        Item first = new Item("goods");
        Item second = new Item("goods");
        Item third = new Item("product");
        hbmTracker.add(first);
        hbmTracker.add(second);
        hbmTracker.add(third);
        List<Item> items = hbmTracker.findByName("goods");
        assertThat(items.size(), is(2));
        assertThat(items.get(0).getName(), is("goods"));
        assertThat(items.get(1).getName(), is("goods"));
    }

    @Test
    public void whenFindItemById() {
       Item item = new Item("product");
       hbmTracker.add(item);
       assertThat(hbmTracker.findById(String.valueOf(item.getIdy())).getName(), is("product"));
    }
}
