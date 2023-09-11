package ru.job4j.tracker;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
    public void setUp() throws SQLException {
        sql = new TrackerSQL(ConnectionRollback.create(this.init()));
    }

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void checkAdd() throws SQLException {
        Item item = new Item("test1", "testDescription", 123L);
        sql.add(item);
        assertThat(sql.findByName("test1").size(), is(3));
    }

    @Test
    public void checkReplace() {
        Item newItem = new Item("test2", "testDescription2", 125L);
        assertThat(sql.replace("2", newItem), is(true));

    }

    @Test
    public void checkDelete() {
        assertThat(sql.delete("2"), is(true));
    }

    @Test
    public void checkFindAll() {
        Item item = new Item("test3", "testDescription3", 123456L);
        Item newItem = new Item("test4", "testDescription4", 125567L);
        sql.add(item);
        sql.add(newItem);
        assertThat(sql.findAll().size(), is(6));
    }

    @Test
    public void checkFindByName() {
        assertThat(sql.findByName("test3").get(0).getId(), is("12"));
    }

    @Test
    public void checkFindById() {
        assertThat(sql.findById("12").getName(),  is("test3"));
    }
}