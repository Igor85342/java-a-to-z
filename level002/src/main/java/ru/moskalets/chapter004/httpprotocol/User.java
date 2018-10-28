package ru.moskalets.chapter004.httpprotocol;

import java.util.Date;

/**
 * Класс реализует модель user.
 */
public class User {

    /**
     * id
     */
    private int id;

    /**
     * login
     */
    private String login;

    private String password;

    private String role;

    /**
     * createDate
     */
    private String createDate;

    public User(int id, String login, String password, String role, String createDate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.createDate = createDate;
    }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.createDate = new Date().toString();
    }

    public User(int id, String login, String password, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }
    /**
     * Возвращает id.
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     * Заполняет id.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }



    /**
     * Возвращает login.
     * @return
     */
    public String getLogin() {
       return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRole() {
        return this.role;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void updateUser(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
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

        if (login != null ? !login.equals(user.login) : user.login != null) {
            return false;
        }
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
