package ru.moskalets.set.task3;

import java.util.Date;
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
     * Constructor.
     * @param sizeArray .
     */
    public SimpleSet(int sizeArray) {
        this.container = new Object[sizeArray];
    }

    /**
     * Main method.
     * @param args .
     */
    public static void main(String[] args) {
        SimpleSet<Integer> ss = new SimpleSet<Integer>(100000);
        Date startSet = new Date();
        for (int i = 0; i < 100000; i++) {
            ss.add(i);
        }
        Date finishSet = new Date();
        System.out.println("Set - " + (finishSet.getTime() - startSet.getTime()));

        SimpleSet<Integer> ssf = new SimpleSet<Integer>(100000);
        Date startFastSet = new Date();
        for (int i = 0; i < 100000; i++) {
            ssf.addFast(i);
        }
        Date finishFastSet = new Date();
        System.out.println("FastSet - " + (finishFastSet.getTime() - startFastSet.getTime()));
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
     * Fast adds an element to the collection.
     * @param o .
     */
    public void addFast(E o) {
        boolean cheak = false;
        if (this.index > 0) {
            int i = 0;
            while (this.container[i] != null) {
                if (o.hashCode() == this.container[i].hashCode()) {
                    cheak = true;
                    break;
                }
                i++;
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
