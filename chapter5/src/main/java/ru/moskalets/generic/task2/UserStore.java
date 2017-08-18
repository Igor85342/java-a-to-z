package ru.moskalets.generic.task2;

/**
 * Class repository for object "User". Implements the interface "Store".
 * @author Igor Moskalets
 * @since 18.08.2017
 */
public class UserStore<T> implements Store {
    public SimpleArray<Base> values;
    public UserStore (int size){
        this.values = new SimpleArray<Base>(size);
    }
    /**
     * This method returns a collection with the objects.
     * @return SimpleArray.
     */
    @Override
    public SimpleArray getValues() {
        return this.values;
    }
    /**
     * This method adds a new object in the collection.
     * @param Base value.
     */
    @Override
    public void addValue(Base value) {
        this.values.add(value);
    }
    /**
     * This method update object in the collection.
     * @param int position.
     * @param Base value.
     */
    @Override
    public void updateValue(int position, Base value) {
        this.values.update(position, value);
    }
    /**
     * This method removes the object and moves the whole collection
     * right from the remote object by one element to the left.
     * @param int position.
     */
    @Override
    public void deleteValue(int position) {
        this.values.delete(position);
    }


}
