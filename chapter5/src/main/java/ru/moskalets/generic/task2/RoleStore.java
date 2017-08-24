package ru.moskalets.generic.task2;

/**
 * Class repository for object "Role". Inherited from class "Store".
 * @author Igor Moskalets
 * @since 18.08.2017
 */
public class RoleStore <T extends Base> extends BaseStore {
    public RoleStore(int size){
        super.values = new SimpleArray(size);
    }
}
