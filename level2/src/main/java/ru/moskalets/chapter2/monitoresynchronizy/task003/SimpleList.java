package ru.moskalets.chapter2.monitoresynchronizy.task003;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Class implements a simple list.
 * author Igor Moskalets
 * Since 31.03.2018
 * @param <E>.
 */
@ThreadSafe
public class SimpleList<E> implements Iterable<E> {
    /**
     * container.
     */
    @GuardedBy("this")
    private Object[] container;
    /**
     * index.
     */
    @GuardedBy("this")
    private int index = 0;
    /**
     * The size of the collection by default.
     */
    private static final int DEFAULTSIZE = 10;
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
        synchronized (this) {
            if (this.index + 1 == this.container.length) {
                expansionSizeArray();
            }
            this.container[index++] = o;
        }
    }
    /**
     * This method returns the value of the element at index.
     * @param pozition The position of the return element.
     * @return Object.
     */
    public E get(int pozition) {
        synchronized (this) {
            return (E) this.container[pozition];
        }
    }
    /**
     * This method returns the value of the element at index.
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        return new ListIterator<E>();
    }
    /**
     * The method increases the size of the collection two times.
     */
    public void expansionSizeArray() {
        synchronized (this) {
            this.container = Arrays.copyOf(this.container, this.container.length * 2);
        }
    }
    /**
     * Method returns all the elements of the collection.
     * @return Object[].
     */
    public Object[] getContainer() {
        synchronized (this) {
            return this.container;
        }
    }
    private class ListIterator<E> implements Iterator<E> {
        /**
         * indexIterator.
         */
        private int indexIterator = 0;

        @Override
        public boolean hasNext() {
            return this.indexIterator < getContainer().length;
        }

        @Override
        public E next() {
                return (E) SimpleList.this.container[this.indexIterator++];
        }
    }
}
