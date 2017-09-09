package ru.moskalets.list.task4;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class SimpleLinkedList.
 * @author Igor Moskalets
 * @since 07.09.2017
 */
public class SimpleLinkedListTest {
    /**
     * Test verifies a call to method getFirst() when the list contains one element.
     */
    @Test
    public void whenListContainsOneElementCallGetFirstReturnFirstElement() {
        SimpleLinkedList<Integer> sll = new SimpleLinkedList<>();
        sll.add(1);
        assertThat(sll.getFirst().getValue(), is(1));
    }

    /**
     * Test verifies a call to method getFirst() when the list contains multiple items.
     */
    @Test
    public void whenListContainsMultipleItemsCallGetFirstReturnFirstElement() {
        SimpleLinkedList<Integer> sll = new SimpleLinkedList<>();
        sll.add(1);
        sll.add(2);
        assertThat(sll.getFirst().getValue(), is(1));
    }

    /**
     * The test checks the method call to getLast() when the list contains one element.
     */
    @Test
    public void whenListContainsOneElementCallGetLastReturnFirstElement() {
        SimpleLinkedList<Integer> sll = new SimpleLinkedList<>();
        sll.add(1);
        assertThat(sll.getLast().getValue(), is(1));
    }

    /**
     * The test checks the method call to getLast() when the list contains multiple items.
     */
    @Test
    public void whenListContainsMultipleItemsCallGetLastReturnFirstElement() {
        SimpleLinkedList<Integer> sll = new SimpleLinkedList<>();
        sll.add(1);
        sll.add(2);
        assertThat(sll.getLast().getValue(), is(2));
    }

    /**
     * The test checks the method hasCycle() when the list contains circuits.
     */
    @Test
    public void whenListContainsCircuitsReturnsTrue() {
        SimpleLinkedList<Integer> sll = new SimpleLinkedList<>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        sll.getLast().setNext(sll.getFirst());
        assertThat(sll.hasCycle(), is(true));
    }

    /**
     * The test checks the method hasCycle() when the list contains no circuits.
     */
    @Test
    public void whenListListContainsNoCircuitsReturnsFalse() {
        SimpleLinkedList<Integer> sll = new SimpleLinkedList<>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        assertThat(sll.hasCycle(), is(false));
    }

}