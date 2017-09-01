package ru.moskalets.list.task1;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Class implements a simple list.
 * author Igor Moskalets
 * Since 22.08.2017
 * @param <E>.
 */
public class SimpleList<E> implements Iterable<E> {
    /**
     * container.
     */
    private Object[] container;
    /**
     * index.
     */
    private int index = 0;
    /**
     * The size of the collection by default.
     */
    private static final int DEFAULTSIZE = 10;
    /**
     * iterator.
     */
    private Iterator<E> iterator;

    /**
     * Constructor.
     */
    public SimpleList() {
        this.container = new Object[this.DEFAULTSIZE];
    };
    /**
     * Constructor.
     * @param size The size of the collection.
     */
    public SimpleList(int size) {
        this.container = new Object[size];
    }
    /**
     * The method adds a new item to the collection.
     * @param o The object that you are adding.
     */
    public void add(E o) {
        if (this.index + 1 == this.container.length) {
            expansionSizeArray();
        }
        this.container[index++] = o;
    }
    /**
     * This method returns the value of the element at index.
     * @param pozition The position of the return element.
     * @return Object.
     */
    public E get(int pozition) {
        return (E) this.container[pozition];
    }
    /**
     * This method returns the value of the element at index.
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        return this.iterator;
    }
    /**
     * The method increases the size of the collection two times.
     */
    public void expansionSizeArray() {
        this.container = Arrays.copyOf(this.container, this.container.length * 2);
    }
    /**
     * Method returns all the elements of the collection.
     * @return Object[].
     */
    public Object[] getContainer() {
        return this.container;
    }
}
