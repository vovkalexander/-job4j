package ru.job4j.tracker;
import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private int idy;
    @Transient
    private String id;
    @Column(name = "names")
    private String name;
    private String description;
    @Column(name = "created")
    private long create;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, String description)    {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public Item(String id, String name, String description, long create) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreated() {
        return this.create;
    }

    public int getIdy() {
        return this.idy;
    }

    public String getId() {
        return this.id;
    }

    public void setIdy(int idy) {
        this.idy = idy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{"
                +
                "idy=" + idy
                +
                ", name='" + name + '\''
                +
                ", description='" + description
                + '\''
                +
                ", create=" + create
                +
                '}';
    }
}
