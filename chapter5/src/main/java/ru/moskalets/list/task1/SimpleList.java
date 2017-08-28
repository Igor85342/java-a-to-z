package ru.moskalets.list.task1;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Class implements a simple list. Implements the interface SimpleContainer.
 * author Igor Moskalets
 * Since 22.08.2017
 */
public class SimpleList<E> implements Iterable<E> {
    private Object[] container;
    private int index = 0;
    /**
     * The size of the collection by default.
     */
    private final int DEFAULTSIZE = 10;
    private Iterator<E> iterator;
    public SimpleList () {
        this.container = new Object[this.DEFAULTSIZE];
    };
    public SimpleList (int size) {
        this.container = new Object[size];
    }
    /**
     * The method adds a new item to the collection.
     * @param Object o.
     * @return void
     */
    public void add(E o) {
        if (this.index + 1 == this.container.length){
            expansionSizeArray();
        }
        this.container[index++] = o;
    }
    /**
     * This method returns the value of the element at index.
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
     * @return void
     */
    public void expansionSizeArray(){
        this.container = Arrays.copyOf(this.container, this.container.length * 2);
    }
    /**
     * Method returns all the elements of the collection.
     * @return Object[].
     */
    public Object[] getContainer(){
        return this.container;
    }
}
