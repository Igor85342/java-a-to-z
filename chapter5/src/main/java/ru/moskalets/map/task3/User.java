package ru.moskalets.map.task3;

import java.util.Calendar;

/**
 * This is the class user.
 */
public class User {
    /**
     * name.
     */
    private String name;
    /**
     * children.
     */
    private int children;
    /**
     * birthday.
     */
    private Calendar birthday;

    /**
     * Constructor.
     * @param name .
     */
    public User(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
