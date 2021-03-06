package ru.moskalets.generic.task2;

/**
 * Class for objects in the repository. Inherited from class "Base".
 * @author Igor Moskalets
 * @since 18.08.2017
 */
public class User extends Base {
    /**
     * id.
     */
    private String id;
    /**
     * Constructor.
     * @param id Id.
     */
    public User(String id) {
        super(id);
    }

}
