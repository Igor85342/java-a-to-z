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
     * Constructor.
     * @param key.
     * @param value.
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
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
     * Set value.
     * @param value.
     */
    public void setValue(V value) {
        this.value = value;
    }

}
