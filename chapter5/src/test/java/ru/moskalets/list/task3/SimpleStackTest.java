package ru.moskalets.list.task3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class SimpleStack.
 * @author Igor Moskalets
 * @since 04.09.2017
 */
public class SimpleStackTest {
    /**
     * Adds a single element. The method is called push(). Returns the first element.
     */
    @Test
    public void whenAddOneElementsAndCallPushReturnThisElement() {
        SimpleStack<Integer> ss = new SimpleStack<>();
        ss.push(1);
        Node result = ss.poll();
        assertThat(result.getNode(), is(1));
    }

    /**
     * Added four elements, called the push () method. The last element becomes the third element.
     */
    @Test
    public void whenAddFourElementsAndCallPushThenBecomesThirdElement() {
        SimpleStack<Integer> ss = new SimpleStack<>();
        ss.push(1);
        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.poll();
        assertThat(ss.getLast().getNode(), is(3));
    }
}