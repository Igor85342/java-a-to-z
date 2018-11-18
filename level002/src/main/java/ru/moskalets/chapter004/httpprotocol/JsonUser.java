package ru.moskalets.chapter004.httpprotocol;

public class JsonUser {
    private String name;
    private String surname;
    private String sex;
    private String description;

    public JsonUser() {
    }
    public JsonUser(String name, String surname, String sex, String description) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getSex() {
        return this.sex;
    }

    public String getDescription() {
        return this.description;
    }
}