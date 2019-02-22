package ru.moskalets.hibernate.section002.task001;

import javax.persistence.*;

@Entity
@Table(name = "carbodyes")
public class CarbodyAnnotations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    public CarbodyAnnotations() {
    }
    public CarbodyAnnotations(int id) {
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