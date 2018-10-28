package ru.moskalets.chapter004.httpprotocol;

public class Role {
    private int id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}