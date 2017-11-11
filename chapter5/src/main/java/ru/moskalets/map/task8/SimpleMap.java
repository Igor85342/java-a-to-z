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
        boolean unique = true;
        int pozition;
        /*for (int i = 0; i < this.index + 1; i++) {
            if (this.table[i] != null) {
                if (key.hashCode() == this.table[i].getKey().hashCode()) {
                    duplicate = true;
                    pozition = i;
                    this.table[pozition].setValue(value);
                    break;
                }
            }
        }*/
        int hash;
        for (Entry entry: this.table){
            if (entry != null && indexFor(hash(key)) == indexFor(entry.getHash())) {
                unique = false;
                hash = entry.getHash();
                replacementValue(hash, value);
                break;
            }
        }
        if (unique) {
            this.table[index++] = new Entry(key, value, indexFor(hash(key)));
        }
        return unique;
    }

    /**
     * The method defines a hash function for the key.
     * @param key.
     * @return.
     */
    public int hash(K key) {
        int hash;
        return (key == null) ? 0 : (hash = key.hashCode()) ^ (hash >>> 16);
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
     * Replaces the value.
     * @param hash
     * @param value
     */
    public void replacementValue(int hash, V value) {
        getItemToHash(hash).setValue(value);

    }
    public Entry getItemToHash(int hash) {
        Entry result = null;
        for (Entry entry: this.table){
            if (indexFor(hash) == indexFor(entry.getHash())) {
                result = entry;
                break;
            }
        }
        return result;
    }
    /**
     * The method returns the element at key.
     * @param key.
     * @return V.
     */
    public V get(K key) {
        V result = null;
        /*for (int i = 0; i < this.index + 1; i++) {
            if (key.hashCode() == this.table[i].getKey().hashCode()) {
                result = (V) this.table[i].getValue();
                break;
            }
        }*/
        for (Entry entry: this.table){
            if (key.equals(entry.getKey())){
                result = (V) entry.getValue();
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
        return new SimpleMapIterator();
    }

    /**
     * The class implements a simple iterator.
     */
    private class SimpleMapIterator implements Iterator {
        private int indexIterator = 0;

        @Override
        public boolean hasNext() {
            //return this.indexIterator < SimpleMap.this.index;
            boolean cheak = false;
            //int k = 1;
            if (this.indexIterator < SimpleMap.this.table.length) {
                for (int i = this.indexIterator; i < SimpleMap.this.table.length; i++ ) {
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
            while (result == null) {
                result = SimpleMap.this.table[this.indexIterator++];
            }
            /*if (SimpleMap.this.table[this.indexIterator] == null) {
                this.indexIterator++;
            } else {
                result = (K) SimpleMap.this.table[this.indexIterator++].getKey();
            }*/
            /**while (SimpleMap.this.table[this.indexIterator] != null) {
                this.indexIterator++;
            }*/

            return result;
        }
    }
}
