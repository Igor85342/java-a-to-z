package ru.moskalets.hibernate.section002.task001;

public class CarbodyXML {
    private int id;
    private String name;
    public CarbodyXML() {
    }
    public CarbodyXML(int id) {
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