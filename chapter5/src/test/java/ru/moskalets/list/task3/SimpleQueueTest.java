package ru.moskalets.list.task3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class SimpleQueue.
 * @author Igor Moskalets
 * @since 04.09.2017
 */
public class SimpleQueueTest {
    /**
     * Adds a single element. The method is called push(). Returns the first element.
     */
    @Test
    public void whenAddOneElementsAndCallPushReturnThisElement() {
        SimpleQueue<Integer> sq = new SimpleQueue();
        sq.push(1);
        Node result = sq.poll();
        assertThat(result.getNode(), is(1));
    }

    /**
     * Added three elements, called the push () method. The first element becomes the second element.
     */
    @Test
    public void whenAddThreeElementsAndCallPushThenBecomesSecondElement() {
        SimpleQueue<Integer> sq = new SimpleQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.poll();
        assertThat(sq.getFirst().getNode(), is(2));
    }
}