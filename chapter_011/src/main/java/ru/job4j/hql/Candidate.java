package ru.job4j.hql;
import javax.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int experience;
    private int salary;

    public Candidate() {
    }

    public static Candidate of(String name, int experience, int salary) {
        Candidate candidate = new Candidate();
        candidate.name = name;
        candidate.experience = experience;
        candidate.salary = salary;
        return candidate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Candidate: id=%d, name = %s, experience = %d, salary=%d", id, name,
                experience, salary);
    }
}
