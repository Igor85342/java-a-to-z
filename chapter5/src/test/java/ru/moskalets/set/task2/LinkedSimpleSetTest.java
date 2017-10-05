package ru.moskalets.set.task2;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class LinkedSimpleSet.
 * @author Igor Moskalets
 * @since 05.10.2017
 */
public class LinkedSimpleSetTest {
    /**
     * Test checks that adding a single element and the first element and call the last element.
     */
    @Test
    public void testAddOneItem() {
        LinkedSimpleSet<Integer> lss = new LinkedSimpleSet<Integer>();
        lss.add(1);
        assertThat(lss.getFirst().getE(), is(1));
        assertThat(lss.getLast().getE(), is(1));
    }

    /**
     * Test checks the addition of unique elements.
     */
    @Test
    public void testAddingFewUniqueItems() {
        LinkedSimpleSet<Integer> lss = new LinkedSimpleSet<Integer>();
        lss.add(1);
        lss.add(2);
        assertThat(lss.getFirst().getE(), is(1));
        assertThat(lss.getLast().getE(), is(2));
    }

    /**
     * The test checks for addition of duplicate elements. In the end, are added to the collection just unique.
     */
    @Test
    public void testAddMultipleIdenticalItems() {
        LinkedSimpleSet<Integer> lss = new LinkedSimpleSet<Integer>();
        lss.add(1);
        lss.add(2);
        lss.add(1);
        lss.add(3);
        lss.add(2);
        lss.add(1);
        lss.add(3);
        assertThat(lss.getLast().getE(), is(3));
        assertThat(lss.getSize(), is(3));
    }

    /**
     * Check the operation of the next () method. Adds five elements.
     * The next() method is invoked three times. Returns the third element.
     */
    @Test
    public void testNextLinkedSimpleSetIterator() {
        LinkedSimpleSet<Integer> lss = new LinkedSimpleSet<Integer>();
        lss.add(1);
        lss.add(2);
        lss.add(3);
        lss.add(4);
        lss.add(5);
        Iterator iter = lss.iterator();
        iter.next();
        iter.next();
        int result = (Integer) iter.next();
        assertThat(result, is(3));
    }

    /**
     * Check the operation of the method hasNext(). Should return true.
     */
    @Test
    public void testHasNextLinkedSimpleSetIteratorReturnTrue() {
        LinkedSimpleSet<Integer> ss = new LinkedSimpleSet<Integer>();
        ss.add(1);
        ss.add(2);
        ss.add(3);
        Iterator iter = ss.iterator();
        boolean result1 = iter.hasNext();
        iter.next();
        iter.next();
        iter.hasNext();
        boolean result2 = iter.hasNext();
        assertThat(result1, is(true));
        assertThat(result2, is(true));
    }

    /**
     * Check the operation of the method hasNext(). Should return false.
     */
    @Test
    public void testHasNextLinkedSimpleSetIteratorReturnFalse() {
        LinkedSimpleSet<Integer> ss = new LinkedSimpleSet<Integer>();
        ss.add(1);
        ss.add(2);
        Iterator iter = ss.iterator();
        iter.next();
        iter.next();
        iter.hasNext();
        boolean result = iter.hasNext();
        assertThat(result, is(false));
    }
}