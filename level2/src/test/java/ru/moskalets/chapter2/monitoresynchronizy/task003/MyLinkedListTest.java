package ru.moskalets.chapter2.monitoresynchronizy.task003;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class MyLinkedList.
 * @author Igor Moskalets
 * @since 31.03.2018
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
    @Test
    public void whenExecuteTwoThreadsAddElementThanAddingTwoElements() throws InterruptedException {
        MyLinkedList<String> mll = new MyLinkedList<String>();
        Thread t001 = new Thread() {
            @Override
            public void run() {
                mll.add("First");
            }
        };
        Thread t002 = new Thread() {
            @Override
             public void run() {
                mll.add("Second");
            }
        };
        t001.start();
        t001.join();
        t002.start();
        t002.join();
        assertThat(mll.getFirst().getNode(), is("First"));
        assertThat(mll.getLast().getNode(), is("Second"));
    }
}