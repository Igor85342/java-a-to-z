package ru.moskalets.hibernate.section002.task001;

public class TransmissionXML {
    private int id;
    private String name;
    public TransmissionXML() {
    }
    public TransmissionXML(int id) {
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