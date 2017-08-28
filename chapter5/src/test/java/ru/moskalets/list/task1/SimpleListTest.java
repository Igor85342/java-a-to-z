package ru.moskalets.list.task1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Testing the class SimpleList.
 * @author Igor Moskalets
 * @since 22.08.2017
 */
public class SimpleListTest {
    /**
     * This method tests adding an item to the collection. And then returns this element.
     */
    @Test
    public void whenAddElementAndGetThisElementReturnThisElement() {
        SimpleList<String> sl = new SimpleList<String>();
        sl.add("First");
        assertThat(sl.get(0), is("First"));
    }
    /**
     * This method tests the increase in the collection twice.
     */
    @Test
    public void whenSizeArrayExpansionReturnSizeDoubled(){
        SimpleList<String> sl = new SimpleList<String>(2);
        sl.expansionSizeArray();
        assertThat(sl.getContainer().length, is(4));
    }
}