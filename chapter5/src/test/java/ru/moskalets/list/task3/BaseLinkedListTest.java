package ru.moskalets.list.task3;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class BaseLinkedList.
 * @author Igor Moskalets
 * @since 04.09.2017
 */
public class BaseLinkedListTest {
    /**
     * Adding a single element. Call the first element. Returns the first element.
     */
    @Test
    public void whenAddOneElementThenReturnFirstElement() {
        BaseLinkedList<Integer> bll = new BaseLinkedList<>();
        bll.push(1);
        assertThat(bll.getFirst().getNode(), is(1));
    }

    /**
     * Adding a single element. Call the last element. Returns the first element.
     */
    @Test
    public void whenAddOneElementThenReturnLastElement() {
        BaseLinkedList<Integer> bll = new BaseLinkedList<>();
        bll.push(1);
        assertThat(bll.getLast().getNode(), is(1));
    }

    /**
     * The addition of two elements. Call the last element. Returns the second element.
     */
    @Test
    public void whenAddTwoElementsThenReturnSecondElement() {
        BaseLinkedList<Integer> bll = new BaseLinkedList<>();
        bll.push(1);
        bll.push(2);
        assertThat(bll.getLast().getNode(), is(2));
    }
}