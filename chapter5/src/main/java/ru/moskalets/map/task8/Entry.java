package ru.moskalets.map.task8;

/**
 * Class that implements element, which contains a pair key - value.
 * @param <K>
 * @param <V>
 */
public class Entry<K, V> {
    /**
     * Key.
     */
    private K key;
    /**
     * Value.
     */
    private V value;
    /**
     * Hash.
     */
    private int hash;
    /**
     * Constructor.
     * @param key.
     * @param value.
     * @param hash.
     */
    public Entry(K key, V value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
    }

    /**
     * Get key.
     * @return K.
     */
    public K getKey() {
        return this.key;
    }

    /**
     * Get value.
     * @return V.
     */
    public V getValue() {
        return this.value;
    }

    /**
     * Get hash.
     * @return int.
     */
    public int getHash() {
        return this.hash;
    }

    /**
     * Set value.
     * @param value.
     */
    public void setValue(V value) {
        this.value = value;
    }

}
