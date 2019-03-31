package ru.moskalets.hibernate.section002.task001;

public class MotorXML {
    private int id;
    private String name;
    public MotorXML() {
    }
    public MotorXML(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MotorXML motorXML = (MotorXML) o;

        if (id != motorXML.id) {
            return false;
        }
        return name != null ? name.equals(motorXML.name) : motorXML.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}