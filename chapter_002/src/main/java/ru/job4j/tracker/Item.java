package ru.job4j.tracker;

public class    Item {
    private String id;
    private String name;
    private String description;
    private long create;
    public Item() {
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
    public String getId() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreate(long create) {
        this.create = create;
    }
    public void setId(String id) {
        this.id = id;
    }
}
