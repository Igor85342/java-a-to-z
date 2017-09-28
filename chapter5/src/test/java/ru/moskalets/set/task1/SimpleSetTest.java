package ru.moskalets.set.task1;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class SimpleSet.
 * @author Igor Moskalets
 * @since 13.09.2017
 */
public class SimpleSetTest {
    /*@Test
    public void when() {
        SimpleSet<String> ss = mock(SimpleSet.class);
        when(ss.add("First")).
    }*/
    /**
     * Added one item. Is called the first element, returns the first element.
     */
    @Test
    public void whenyouAddOneElementReturnFirstElement() {
        SimpleSet<String> ss = new SimpleSet<String>(10);
        ss.add("First");
        assertThat(ss.get(0), is("First"));
    }

    /**
     * Added a few items. Is called the second element, returns the second element.
     */
    @Test
    public void whenAddedMultipleItemsAndIsCalledElementAtPositionIsReturnedToCallingElement() {
        SimpleSet<Integer> ss = new SimpleSet<Integer>(10);
        ss.add(1);
        ss.add(2);
        ss.add(3);
        assertThat(ss.get(1), is(2));
    }

    /**
     * Adds the four elements. The second and third element are identical.
     * The third element is not added. The third element is invoked, it returns the fourth.
     */
    @Test
    public void whenYouAddElementAlreadyContainedInCollectionReturnsNextElement() {
        SimpleSet<Integer> ss = new SimpleSet<Integer>(10);
        ss.add(1);
        ss.add(2);
        ss.add(2);
        ss.add(3);
        assertThat(ss.get(2), is(3));
    }

    /**
     * Added duplicate items. The result is a collection of records only unique elements.
     * The test checks the size of the array of unique items.
     */
    @Test
    public void whenAddingDuplicateItemsReturnsNumberUniqueElements() {
        SimpleSet<String> ss = new SimpleSet<String>(10);
        ss.add("First");
        ss.add("First");
        ss.add("Second");
        ss.add("First");
        ss.add("Second");
        assertThat(ss.getSize(), is(2));
    }

    /**
     * Check the operation of the next () method. Adds five elements.
     * The next() method is invoked three times. Returns the third element.
     */
    @Test
    public void testNextSimpleSetIterator() {
        SimpleSet<Integer> ss = new SimpleSet<Integer>(10);
        ss.add(1);
        ss.add(2);
        ss.add(3);
        ss.add(4);
        ss.add(5);
        Iterator iter = ss.iterator();
        iter.next();
        iter.next();
        int result = (Integer) iter.next();
        assertThat(result, is(3));
    }
    /**
     * Check the operation of the method hasNext(). Should return true.
     */
    @Test
    public void testHasNextSimpleSetIteratorReturnTrue() {
        SimpleSet<Integer> ss = new SimpleSet<Integer>(10);
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
    public void testHasNextSimpleSetIteratorReturnFalse() {
        SimpleSet<Integer> ss = new SimpleSet<Integer>(10);
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