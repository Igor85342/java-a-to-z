package ru.moskalets.generic.task2;

/**
 * Class repository for object "Role". Inherited from class "Store".
 * @author Igor Moskalets
 * @since 18.08.2017
 * @param <T> .
 */
public class RoleStore<T extends Base> extends BaseStore {
    //private SimpleArray<T> values;
    /**
     * Constructor.
     * @param size .
     */
    public RoleStore(int size) {
        super(size);
    }
}
