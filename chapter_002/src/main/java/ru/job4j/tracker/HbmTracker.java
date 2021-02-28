package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements ITracker, AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(HbmTracker.class);
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean rst = false;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            item.setIdy(Integer.parseInt(id));
            session.update(item);
            session.getTransaction().commit();
            rst  = true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return rst;
    }

    @Override
    public boolean delete(String id) {
        boolean rst = false;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Item item = new Item();
            item.setIdy(Integer.parseInt(id));
            session.delete(item);
            session.getTransaction().commit();
            rst = true;
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return rst;
    }

    @Override
    public List<Item> findAll() {
        List result = new ArrayList();
        try (Session session = sf.openSession()) {
            session.beginTransaction();
             result = session.createQuery("from ru.job4j.tracker.Item").list();
             session.getTransaction().commit();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List result = new ArrayList();
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from ru.job4j.tracker.Item where name like :key").
                    setParameter("key", key).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            item = (Item) session.byId(Item.class).load(Integer.parseInt(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            sf.getCurrentSession().getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
