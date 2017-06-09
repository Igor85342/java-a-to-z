package ru.moskalets.generalizations.task2;

/**
 * The User Class.
 * author Igor Moskalets
 * Since 09.06.2017
 */
public class User {
    private Integer id;
    private String name;
    private String city;
    public User(Integer id, String name, String city){
        this.id = id;
        this.name = name;
        this.city = city;
    }
    /**
     * Returns ID.
     * @return Integer.
     */
    public Integer getID(){
        return this.id;
    }
}
