package ru.moskalets.generic.task2;

/**
 * Class repository for object "User". Inherited from class "Store".
 * @author Igor Moskalets
 * @since 18.08.2017
 * @param <T> Extends Base.
 */
public class UserStore<T extends Base> extends BaseStore {
   //private SimpleArray<T> values;
    /**
     * Constructor.
     * @param size The size of the collection.
     */
    public UserStore(int size) {
        super(size);
    }
}
