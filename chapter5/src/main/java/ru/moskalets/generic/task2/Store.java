package ru.moskalets.generic.task2;

/**
 * This interface describes the class of storage.
 * @author Igor Moskalets
 * @since 18.08.2017
 */
public interface Store<T extends Base> {
    /**
     * This method returns a collection with the objects.
     * @return SimpleArray<T>.
     */
    public SimpleArray<T> getValues();
    /**
     * This method adds a new object in the collection.
     * @param T value.
     */
    public void addValue(T value);
    /**
     * This method update object in the collection.
     * @param int position.
     * @param T value.
     */
    public void updateValue(int position, T value);
    /**
     * This method removes the object and moves the whole collection
     * right from the remote object by one element to the left.
     * @param int position.
     */
    public void deleteValue(int position);
}
