package ru.moskalets.map.task8;


import java.util.Iterator;

/**
 * Implementation of simple collections whose elements are pairs key - value.
 * @param <K>.
 * @param <V>.
 */
public class SimpleMap<K, V> implements Iterable<K> {
    /**
     * table - an array in which items are stored.
     */
    private Entry[] table;
    /**
     * Index.
     */
    private int index = 0;

    /**
     * Constructor.
     * @param size.
     */
    public SimpleMap(int size) {
        this.table = new Entry[size];
    }

    /**
     * Method inserts the new element.
     * @param key.
     * @param value.
     * @return boolean.
     */
    public boolean insert(K key, V value) {
        boolean duplicate = false;
        int pozition;
        for (int i = 0; i < this.index + 1; i++) {
            if (this.table[i] != null) {
                if (key.hashCode() == this.table[i].getKey().hashCode()) {
                    duplicate = true;
                    pozition = i;
                    this.table[pozition].setValue(value);
                    break;
                }
            }
        }
        if (!duplicate) {
            this.table[index++] = new Entry(key, value);
        }
        return !duplicate;
    }

    /**
     * The method returns the element at key.
     * @param key.
     * @return V.
     */
    public V get(K key) {
        V result = null;
        for (int i = 0; i < this.index + 1; i++) {
            if (key.hashCode() == this.table[i].getKey().hashCode()) {
                result = (V) this.table[i].getValue();
                break;
            }
        }
        return result;
    }

    /**
     * The method removes element by key.
     * @param key.
     * @return boolean.
     */
    public boolean delete(K key) {
        Entry[] resultArray = new Entry[this.table.length - 1];
        boolean cheak = false;
        int k = 0;
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] != null && key.hashCode() != this.table[i].getKey().hashCode()) {
                resultArray[k] = this.table[i];
            } else {
                cheak = true;
            }
        }
        this.table = resultArray;
        this.index--;
        return cheak;
    }

    /**
     * The method returns a new iterator.
     * @return Iterator<K>.
     */
    @Override
    public Iterator<K> iterator() {
        return new SimpleMapIterator<K>();
    }

    /**
     * The class implements a simple iterator.
     * @param <K>.
     */
    private class SimpleMapIterator<K> implements Iterator<K> {
        private int indexIterator = 0;

        @Override
        public boolean hasNext() {
            return this.indexIterator < SimpleMap.this.index;
        }

        @Override
        public K next() {
            return (K) SimpleMap.this.table[this.indexIterator++].getKey();
        }
    }
}
