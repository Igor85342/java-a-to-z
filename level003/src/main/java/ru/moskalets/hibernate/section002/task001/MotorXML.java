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
}