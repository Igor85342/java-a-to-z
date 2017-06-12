package ru.moskalets.sorting.task1;
/**
 * The User Class.
 * author Igor Moskalets
 * Since 12.06.2017
 */
public class User implements Comparable<User> {
    private String name;
    private Integer age;
    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    /**
     * Return Name.
     * @return String.
     */
    public String getName(){
        return this.name;
    }
    /**
     * Return age.
     * @return Integer.
     */
    public Integer getAge(){
        return this.age;
    }
    @Override
    public int compareTo(User o) {
        return this.getAge().compareTo(o.getAge());
    }
}
