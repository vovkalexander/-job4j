package ru.job4j.tracker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;

public class HibernateRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            ItemForHiber item = create(new ItemForHiber("Learn Hibernate"), sf);
            System.out.println(item);
            item.setName("Learn Hibernate 5.");
            update(item, sf);
            System.out.println(item);
            ItemForHiber rsl = findById(item.getId(), sf);
            System.out.println(rsl);
            delete(rsl.getId(), sf);
            List<ItemForHiber> list = findAll(sf);
            for (ItemForHiber it : list) {
                System.out.println(it);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static ItemForHiber create(ItemForHiber item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static void update(ItemForHiber item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        ItemForHiber item = new ItemForHiber();
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    public static List<ItemForHiber> findAll(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List result = session.createQuery("from ru.job4j.tracker.ItemForHiber").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static ItemForHiber findById(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        ItemForHiber result = session.get(ItemForHiber.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
