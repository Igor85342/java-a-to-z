package ru.moskalets.sorting.task2;
/**
 * The User Class.
 * author Igor Moskalets
 * Since 12.06.2017
 */
public class User implements Comparable<User> {
    /**
     * Name user.
     */
    private String name;
    /**
     * Age user.
     */
    private Integer age;
    /**
     * Constructor.
     * @param name Name user.
     * @param age Age user.
     */
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    /**
     * Return Name.
     * @return String.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Return age.
     * @return Integer.
     */
    public Integer getAge() {
        return this.age;
    }
    @Override
    public int compareTo(User o) {
        return this.getAge().compareTo(o.getAge());
    }
}
