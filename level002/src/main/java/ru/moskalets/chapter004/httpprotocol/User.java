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
     * name
     */
    private String name;

    /**
     * login
     */
    private String login;

    /**
     * email
     */
    private String email;

    /**
     * createDate
     */
    private String createDate;

    /**
     * Конструктор.
     * @param name
     * @param login
     * @param email
     */
    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = new Date().toString();
    }

    /**
     * Конструктор.
     * @param id
     * @param name
     * @param login
     * @param email
     */
    public User(int id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
    }
    public User(int id, String name, String login, String email, String createDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
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
     * Возвращает name.
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Возвращает login.
     * @return
     */
    public String getLogin() {
       return this.login;
    }

    /**
     * Возвращает email.
     * @return
     */
    public String getEmail() {
        return this.email;
    }

    public String getCreateDate() {
        return this.createDate;
    }
    /**
     * Изменяет name, login, email.
     * @param name
     * @param login
     * @param email
     */
    public void updateUser(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
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

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        if (login != null ? !login.equals(user.login) : user.login != null) {
            return false;
        }
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
