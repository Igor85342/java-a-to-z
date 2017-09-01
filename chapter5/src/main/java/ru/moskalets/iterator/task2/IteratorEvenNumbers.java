package ru.moskalets.iterator.task2;

import java.util.Iterator;

/**
 * his class implements an iterator for the array,
 * which returns even numbers and checks whether the next number is even.
 * author Igor Moskalets
 * Since 01.08.2017
 */
public class IteratorEvenNumbers implements Iterator {
    /**
     * Values - int[].
     */
    private final int[] values;
    /**
     * Index.
     */
    private int index;
    /**
     * Constructor.
     * @param values Numbers.
     */
    public IteratorEvenNumbers(final int[] values) {
        this.values = values;
    }
    /**
     * This method checks whether the next number in the array is even.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        boolean cheak =  false;
        for (int i = this.index; i < this.values.length; i++) {
            if (this.values[i] % 2 == 0) {
                cheak = true;
                break;
            }
        }
        return cheak;
    }
    /**
     * This method returns the next even element in the array.
     * @return Object.
     */
    @Override
    public Object next() {
        while (this.values[this.index] % 2 != 0) {
            this.index++;
        }
        return this.values[this.index++];
    }
}
