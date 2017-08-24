package ru.moskalets.generic.task2;

/**
 * Created by Пользователь on 22.08.2017.
 */
public abstract class BaseStore <T extends Base> implements Store<T> {
    public SimpleArray<T> values;
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
    public void addValue(T value) {
        this.values.add(value);
    }
    /**
     * This method update object in the collection.
     * @param int position.
     * @param Base value.
     */
    @Override
    public void updateValue(int position, T value) {
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

