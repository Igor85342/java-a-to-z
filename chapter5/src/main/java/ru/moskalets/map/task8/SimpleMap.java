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
     * Capacity
     */
    private int capacity = 100;

    /**
     * Constructor.
     * @param size.
     */
    public SimpleMap() {
        this.table = new Entry[this.capacity];
    }

    /**
     * Method inserts the new element.
     * @param key.
     * @param value.
     * @return boolean.
     */
    public boolean insert(K key, V value) {
        boolean unique = true;
        int pozition = indexFor(hash(key));
        if (this.table[pozition] == null) {
            this.table[pozition] = new Entry(key, value, hash(key));
        } else {
            unique = false;
        }
        return unique;
    }

    /**
     * The method defines a hash function for the key.
     * @param key.
     * @return.
     */
    public int hash(K key) {
        int hash = key.hashCode();
        return (key == null) ? 0 : (hash) ^ (hash >>> 16);
    }

    /**
     * The method determines the index in the array table.
     * @param hash.
     * @return.
     */
    public int indexFor(int hash) {
        return hash & (this.table.length - 1);
    }
    /**
     * The method returns the element at key.
     * @param key.
     * @return V.
     */
    public V get(K key) {
        return (V) this.table[indexFor(hash(key))].getValue();
    }

    /**
     * The method removes element by key.
     * @param key.
     * @return boolean.
     */
    public boolean delete(K key) {
        boolean cheak = false;
        if (this.table[indexFor(hash(key))] != null) {
            this.table[indexFor(hash(key))] = null;
            cheak = true;
        }
        return cheak;
    }

    /**
     * The method returns a new iterator.
     * @return Iterator<K>.
     */
    @Override
    public Iterator<K> iterator() {
        return new SimpleMapIterator();
    }

    /**
     * The class implements a simple iterator.
     */
    private class SimpleMapIterator implements Iterator {
        private int indexIterator = 0;

        @Override
        public boolean hasNext() {
            boolean cheak = false;
            if (this.indexIterator < SimpleMap.this.table.length) {
                for (int i = this.indexIterator; i < SimpleMap.this.table.length; i++) {
                    if (SimpleMap.this.table[i] != null) {
                        cheak = true;
                        break;
                    }
                }
            }
            return cheak;
        }

        @Override
        public Entry next() {
            Entry result = SimpleMap.this.table[this.indexIterator++];
            if (hasNext()) {
                while (result == null) {
                    result = SimpleMap.this.table[this.indexIterator++];
                }
            } else {
                result = null;
            }
            return result;
        }
    }
}
