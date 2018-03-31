package ru.moskalets.chapter2.monitoresynchronizy.task003;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class SimpleList.
 * @author Igor Moskalets
 * @since 31.03.2018
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
    public void whenSizeArrayExpansionReturnSizeDoubled() {
        SimpleList<String> sl = new SimpleList<String>(2);
        sl.expansionSizeArray();
        assertThat(sl.getContainer().length, is(4));
    }

    /**
     * Tests the addition of two items in two different threads.
     * @throws InterruptedException
     */
    @Test
    public void whenExecuteTwoThreadAddElementThenAddingTwoElements() throws InterruptedException {
        SimpleList<String> sl = new SimpleList<String>();
        Thread thread001 = new Thread() {
            @Override
            public void run() {
                sl.add("First");
            }
        };
        Thread thread002 = new Thread() {
            @Override
            public void run() {
                sl.add("First");
            }
        };
        thread001.start();
        thread002.start();
        thread001.join();
        thread002.join();
        assertThat(sl.getContainer()[0], is("First"));
        assertThat(sl.getContainer()[1], is("First"));
    }
}