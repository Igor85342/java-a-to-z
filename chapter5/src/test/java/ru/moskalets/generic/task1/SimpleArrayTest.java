package ru.moskalets.generic.task1;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

/**
 * Testing the method SimpleArray.
 * @author Igor Moskalets
 * @since 14.08.2017
 */
public class SimpleArrayTest {
    /**
     * This test initialisere collection, and adds the text element.
     */
    @Test
    public void whenCreateContainterShouldReturnTheSameType() {
        SimpleArray<String> sa = new SimpleArray<String>(4);
        sa.add("Test");
        String result = sa.get(0);
        assertThat(result, is("Test"));
    }
    /**
     * This test initialisere collection and adds an Integer element.
     */
    @Test
    public void whenTypeIntShouldReturnInt() {
        SimpleArray<Integer> sa = new SimpleArray<Integer>(4);
        sa.add(5);
        int result = sa.get(0);
        assertThat(result, is(5));
    }
    /**
     * This test checks the method update(int position, T value) and returns the modified item.
     */
    @Test
    public void whenUpdatevalueReturnChangedvalue() {
        SimpleArray<String> sa = new SimpleArray<String>(4);
        sa.add("Test");
        sa.update(0, "Update");
        String result = sa.get(0);
        assertThat(result, is("Update"));
    }
    /**
     * This test checks the delete method(int position) and returns the following after the remote element.
     */
    @Test
    public void whenDeleteElementReturnArrayWithThisElement() {
        SimpleArray<Integer> sa = new SimpleArray<Integer>(5);
        sa.add(0);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.add(4);
        sa.delete(3);
        int result = sa.get(3);
        assertThat(result, is(4));
    }
}