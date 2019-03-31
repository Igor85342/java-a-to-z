package ru.moskalets.hibernate.section002.task001;

import java.util.Set;

public class User {
    private int id;
    private String login;
    private String password;
    private Set<CarXML> cars;
    public User() {
    }
    public User(int id, String login, String password, Set<CarXML> cars) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.cars = cars;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return this.login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<CarXML> getCars() {
        return this.cars;
    }
    public void setCars(Set<CarXML> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return login != null ? login.equals(user.login) : user.login == null;
    }

    @Override
    public int hashCode() {
        return login != null ? login.hashCode() : 0;
    }
}