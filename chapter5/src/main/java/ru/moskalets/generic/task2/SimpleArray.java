package ru.moskalets.generic.task2;

/**
 * This class implements the collection.
 * author Igor Moskalets
 * Since 14.08.2017
 * @param <T> .
 */
public class SimpleArray<T> {
    /**
     * objects.
     */
    private Object[] objects;
    /**
     * index.
     */
     private int index = 0;
    /**
     * Constructor.
     * @param size .
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }
    /**
     * This method adds an object to the collection.
     * @param value .
     */
    public void add(T value) {
        this.objects[index++] = value;
    }
    /**
     * This method returns the value of the element at index.
     * @param position .
     * @return T.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }
    /**
     * This method changes the value of the item in the collection and finding it by index.
     * @param position .
     * @param value .
     */
    public void update(int position, T value) {
        if (position <= objects.length - 1) {
            this.objects[position] = value;
        }
    }
    /**
     * This method removes an element by finding it by index.
     * @param position .
     */
    public void delete(int position) {
        Object[] tempObjects = new Object[this.objects.length - 1];
        for (int i = 0; i < position; i++) {
            tempObjects[i] = this.objects[i];
        }
        for (int i = position + 1; i < this.objects.length; i++) {
            tempObjects[i - 1] = this.objects[i];
        }
        this.objects = tempObjects;
    }
}
