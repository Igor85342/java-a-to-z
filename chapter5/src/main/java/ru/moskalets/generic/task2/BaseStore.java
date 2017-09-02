package ru.moskalets.generic.task2;

/**
 * The class implements the interface Store. Is the abstract store.
 * @author Igor Moskalets
 * @since 01.09.2017
 * @param <T> .
 */
public abstract class BaseStore<T extends Base> implements Store<T> {
    /**
     * values.
     */
    private SimpleArray<T> values;

    /**
     * Constructor.
     * @param size .
     */
    protected BaseStore(int size) {
        this.values = new SimpleArray(size);
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
     * @param value .
     */
    @Override
    public void addValue(T value) {
        this.values.add(value);
    }
    /**
     * This method update object in the collection.
     * @param position .
     * @param value .
     */
    @Override
    public void updateValue(int position, T value) {
        this.values.update(position, value);
    }
    /**
     * This method removes the object and moves the whole collection
     * right from the remote object by one element to the left.
     * @param position .
     */
    @Override
    public void deleteValue(int position) {
        this.values.delete(position);
    }

}

