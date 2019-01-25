package ru.moskalets.hibernate.section001.task001;



import java.sql.Timestamp;

public class Item {
    private int id;
    private String description;
    private Timestamp created;
    private boolean done;

    public Item () {
    }

    public Item(String description, boolean done) {
        this.description = description;
        this.done = done;
    }

    public Item(String description, Timestamp created, boolean done) {
        this.description = description;
        this.created = created;
        this.done = done;
    }

    public Item(int id, String description, Timestamp created, boolean done) {
        this.id = id;
        this.description = description;
        this.created = created;
        this.done = done;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Timestamp getCreated() {
        return this.created;
    }

    public boolean getDone() {
        return this.done;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (done != item.done) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        return created != null ? created.equals(item.created) : item.created == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (done ? 1 : 0);
        return result;
    }
}