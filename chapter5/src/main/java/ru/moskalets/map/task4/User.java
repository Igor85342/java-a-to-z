package ru.moskalets.map.task4;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (children != user.children) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }
}
