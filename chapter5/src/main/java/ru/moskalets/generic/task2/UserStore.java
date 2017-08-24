package ru.moskalets.generic.task2;

/**
 * Class repository for object "User". Inherited from class "Store".
 * @author Igor Moskalets
 * @since 18.08.2017
 */
public class UserStore<T extends Base> extends BaseStore {
    public UserStore(int size){
        super.values = new SimpleArray(size);
    }
}
