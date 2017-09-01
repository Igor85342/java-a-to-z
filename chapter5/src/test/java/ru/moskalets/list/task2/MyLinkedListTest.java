package ru.moskalets.list.task2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class MyLinkedList.
 * @author Igor Moskalets
 * @since 29.08.2017
 */
public class MyLinkedListTest {
    /**
     * Test checks the add item.
     */
    @Test
    public void whenAddElementReturnThisElementIntegerCollection() {
        MyLinkedList<Integer> mll = new MyLinkedList<Integer>();
        mll.add(1);
        mll.add(2);
        assertThat(mll.get(1).getNode(), is(1));
        assertThat(mll.get(2).getNode(), is(2));
    }
    /**
     * This test verifies the return of the first item in the collection.
     */
    @Test
    public void whenGetFirstElementReturnFirstElementIntegerCollection() {
        MyLinkedList<Integer> mll = new MyLinkedList<Integer>();
        mll.add(1);
        mll.add(2);
        assertThat(mll.getFirst().getNode(), is(1));
    }
    /**
     * The test checks the return last element in the collection.
     */
    @Test
    public void whenGetLastElementReturnLastElementStirngCollection() {
        MyLinkedList<String> mll = new MyLinkedList<String>();
        mll.add("First");
        mll.add("Second");
        assertThat(mll.getLast().getNode(), is("Second"));
    }
    /**
     * The test checks the return element at the selected position.
     */
    @Test
    public void whenGetPositionreturnElementThisPosition() {
        MyLinkedList<Integer> mll = new MyLinkedList<Integer>();
        for (int i = 1; i < 500; i++) {
            mll.add(i);
        }
        assertThat(mll.get(499).getNode(), is(499));
    }
}