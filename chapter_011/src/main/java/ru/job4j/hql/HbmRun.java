package ru.job4j.hql;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();

        SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        try {
            Session session = sf.openSession();
            session.beginTransaction();
            Candidate one = Candidate.of("Otto", 3, 2500);
            Candidate two = Candidate.of("Joe", 2, 2000);
            Candidate three = Candidate.of("Juan", 5, 5000);
            session.save(one);
            session.save(two);
            session.save(three);

            session.createQuery("from Candidate").list().forEach(System.out::println);

            System.out.println(session.createQuery("from Candidate c where c.id = :fId")
                    .setParameter("fId", 1)
                    .uniqueResult());

            System.out.println(session.createQuery("from Candidate c where c.name = :fName")
                    .setParameter("fName", "Juan")
                    .uniqueResult());

            session.createQuery("update Candidate c set c.name = :fName,"
                            +
                            "c.experience = :fExperience, c.salary = :fSalary where c.id = :fId")
                    .setParameter("fName", "Komuto")
                    .setParameter("fExperience", 10)
                    .setParameter("fSalary", 7000)
                    .setParameter("fId", 2)
                    .executeUpdate();

            session.createQuery("delete from Candidate c where c.id = :fId")
                    .setParameter("fId", 3)
                    .executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
