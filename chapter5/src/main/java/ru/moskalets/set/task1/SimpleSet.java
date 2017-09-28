package ru.moskalets.set.task1;

import java.util.Iterator;

/**
 * Collection that contains only unique elements. Data is stored in the array.
 * @param <E> .
 */
public class SimpleSet<E> implements Iterable<E> {
    /**
     * container.
     */
    private Object[] container;
    /**
     * index.
     */
    private int index = 0;
    /**
     * iterator.
     */
   // private Iterator<E> iterator;

    /**
     * Constructor.
     * @param sizeArray .
     */
    public SimpleSet(int sizeArray) {
        this.container = new Object[sizeArray];
    }

    /**
     * Adds an element to the collection.
     * @param o .
     */
    public void add(E o) {
        boolean cheak = false;
        if (this.index > 0) {
            for (Object oArray : this.container) {
                if (o.equals(oArray)) {
                    cheak = true;
                    break;
                }
            }
        }
        if (!cheak) {
            this.container[this.index++] = o;
        }
    }

    /**
     * Returns the element at position.
     * @param pozition .
     * @return E.
     */
    public E get(int pozition) {
        return (E) this.container[pozition];
    }

    /**
     * Returns the size of the collection.
     * @return int.
     */
    public int getSize() {
        return this.index;
    }

    /**
     * Return the iterator.
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleSetIterator<E>();
    }

    /**
     * A class implements an iterator for sequential iterate through this collection.
     * @param <E> .
     */
    private class SimpleSetIterator<E> implements Iterator<E> {
        /**
         * indexIterator.
         */
        private int indexIterator = 0;

        @Override
        public boolean hasNext() {
            return this.indexIterator < getSize();
        }

        @Override
        public E next() {
            return (E) SimpleSet.this.container[this.indexIterator++];
        }
    }

}
