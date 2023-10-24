package ru.job4j.tracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * TrackerSQL.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    /**
     * Поле - хранит логирование для регистрации сообщений.
     */
    private static final Logger LOG = LoggerFactory.getLogger(TrackerSQL.class);
    /**
     * Поле - хранит ссылку для соединения с баззой данных.
     */
    private Connection connection;
    /**
     * Конструктор для активации подключения к базе данных.
     * @param connection - ссылка на класс Connection;
     */

    public TrackerSQL(Connection connection) {
        this.connection = connection;
    }
    /**
     * Метод реализаущий подключение к базе данных.
     * @return логическое значение.
     */

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }
    /**
     * Метод реализаущий добавление заявки.
     * @param item новая заявка
     */

    @Override
    public Item add(Item item) {
        try (PreparedStatement st = this.connection.prepareStatement("insert into items (names, description, created) VALUES (?, ?, ?) ",
                Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setLong(3, item.getCreated());
            st.executeUpdate();
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                item.setId(generatedKeys.getString(1));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }
    /**
     * Удаляет заменяет заявку.
     * @param item заявка.
     * @param id   заявки.
     * return логическое значение.
     */

    @Override
    public boolean replace(String id, Item item) {
        boolean rst = false;
        try (PreparedStatement st = this.connection.prepareStatement("UPDATE items Set names = ?, description = ?, created = ? where id_items = ? ")) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setLong(3, item.getCreated());
            st.setInt(4, Integer.parseInt(id));
            if (st.executeUpdate() != 0) {
                rst = true;
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return rst;
    }
    /**
     * Удаляет заявку.
     * @param id заявки.
     * return логическое значение.
     */

    @Override
    public boolean delete(String id) {
        boolean rst = false;
        try (PreparedStatement st = this.connection.prepareStatement("DElETE from items where id_items = ?")) {
            st.setInt(1, Integer.parseInt(id));
            if (st.executeUpdate() != 0) {
                rst = true;
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return rst;
    }
    /**
     * Находит все заявки .
     * return список заявок.
     */

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM items");
            while (rs.next()) {
                list.add(new Item(rs.getString("id_items"), rs.getString("names"), rs.getString("description"), rs.getLong("created")));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return list;
    }
    /**
     * Находит заявку по имени.
     * @param name-имя заявки.
     * return список заявок(массив) с именим key.
     */

    @Override
    public List<Item> findByName(String name) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement st = this.connection.prepareStatement("SELECT * from items where names = ?")) {
            st.setString(1, (name));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getString("id_items"), rs.getString("names"), rs.getString("description"), rs.getLong("created")));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return list;
    }
    /**
     * Находит заявку по ID.
     * @param id заявки.
     * return заявку.
     */

    @Override
    public Item findById(String id) {
        Item item = null;
        try (PreparedStatement st = this.connection.prepareStatement("SELECT * from items where id_items = ?")) {
            st.setInt(1, Integer.parseInt(id));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                item = new Item(rs.getString("id_items"), rs.getString("names"), rs.getString("description"), rs.getLong("created"));
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return item;
    }
    /**
     * Закрывает соединение с базой данных.
     */

    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}



