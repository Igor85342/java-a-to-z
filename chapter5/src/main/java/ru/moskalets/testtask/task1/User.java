package ru.moskalets.testtask.task1;

/**
 * The class stores information about user name and number of his passport.
 * author Igor Moskalets
 * Since 15.06.2017
 */
public class User {
    /**
     * Name.
     */
    private String name;
    /**
     * Passport.
     */
    private String passport;

    /**
     *
     * @param name Name user.
     * @param passport Passport user.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Return name.
     * @return String
     */
    public String getName() {
        return this.name;
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
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }
}
