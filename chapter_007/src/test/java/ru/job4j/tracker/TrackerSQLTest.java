package ru.job4j.tracker;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * TrackerSQLTest.
 * @author Vovk Alexander (vovk.ag747@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerSQLTest {
    private TrackerSQL sql;
    @Before
    public void setUp() {
        sql = new TrackerSQL();
    }
    @Test
    public void checkAdd() {
        Item item = new Item("test1", "testDescription", 123L);
        sql.add(item);
        assertThat(sql.findAll().size(), is(1));
    }
    @Test
    public void checkReplace() {
        Item newItem = new Item("test2", "testDescription2", 125L);
        assertThat(sql.replace("1", newItem), is(true));

    }
    @Test
    public void checkDelete() {
        assertThat(sql.delete("1"), is(true));
    }
    @Test
    public void checkFindAll() {
        Item item = new Item("test3", "testDescription3", 123456L);
        Item newItem = new Item("test4", "testDescription4", 125567L);
        sql.add(item);
        sql.add(newItem);
        assertThat(sql.findAll().size(), is(2));
    }
    @Test
    public void checkFindByName() {
        assertThat(sql.findByName("test3").get(0).getId(), is("4"));
    }
    @Test
    public void checkFindById() {
        assertThat(sql.findById("4").getName(),  is("test3"));
    }
}