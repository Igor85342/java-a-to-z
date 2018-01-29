package ru.moskalets.set.task3;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class SimpleSet.
 * @author Igor Moskalets
 */
public class SimpleSetTest {
    /**
     * Added one item. Is called the first element, returns the first element.
     */
    @Test
    public void whenAddOneElementReturnFirstElement() {
        SimpleSet<String> ss = new SimpleSet<String>(10);
        ss.add("First");
        assertThat(ss.get(0), is("First"));
    }

    @Test
    public void whenFastAddOneElementReturnFirstElement() {
        SimpleSet<String> ssf = new SimpleSet<String>(10);
        ssf.addFast("First");
        assertThat(ssf.get(0), is("First"));
    }

    /**
     * Test addFast(). Added one item. Is called the first element, returns the first element.
     */
    @Test
    public void whenyouAddFastOneElementReturnFirstElement() {
        SimpleSet<String> ss = new SimpleSet<String>(10);
        ss.add("First");
        assertThat(ss.get(0), is("First"));
    }
    /**
     * Added a few items. Is called the second element, returns the second element.
     */
    @Test
    public void whenAddedMultipleItemsAndIsCalledElementAtPositionIsReturnedToCallingElement() {
        ru.moskalets.set.task1.SimpleSet<Integer> ss = new ru.moskalets.set.task1.SimpleSet<Integer>(10);
        ss.add(1);
        ss.add(2);
        ss.add(3);
        assertThat(ss.get(1), is(2));
    }

    /**
     * Test addFast(). Added a few items. Is called the second element, returns the second element.
     */
    @Test
    public void whenAddedFastMultipleItemsAndIsCalledElementAtPositionIsReturnedToCallingElement() {
        ru.moskalets.set.task1.SimpleSet<Integer> ss = new ru.moskalets.set.task1.SimpleSet<Integer>(10);
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
        ru.moskalets.set.task1.SimpleSet<Integer> ss = new ru.moskalets.set.task1.SimpleSet<Integer>(10);
        ss.add(1);
        ss.add(2);
        ss.add(2);
        ss.add(3);
        assertThat(ss.get(2), is(3));
    }

    /**
     * Test addFast(). Fast adds the four elements. The second and third element are identical.
     * The third element is not added. The third element is invoked, it returns the fourth.
     */

    @Test
    public void whenYouAddFastElementAlreadyContainedInCollectionReturnsNextElement() {
        ru.moskalets.set.task1.SimpleSet<Integer> ss = new ru.moskalets.set.task1.SimpleSet<Integer>(10);
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
        ru.moskalets.set.task1.SimpleSet<String> ss = new ru.moskalets.set.task1.SimpleSet<String>(10);
        ss.add("First");
        ss.add("First");
        ss.add("Second");
        ss.add("First");
        ss.add("Second");
        assertThat(ss.getSize(), is(2));
    }
    /**
     * Fast added duplicate items. Test addFast(). The result is a collection of records only unique elements.
     * The test checks the size of the array of unique items.
     */
    @Test
    public void whenFastAddingDuplicateItemsReturnsNumberUniqueElements() {
        ru.moskalets.set.task1.SimpleSet<String> ss = new ru.moskalets.set.task1.SimpleSet<String>(10);
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
        ru.moskalets.set.task1.SimpleSet<Integer> ss = new ru.moskalets.set.task1.SimpleSet<Integer>(10);
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
        ru.moskalets.set.task1.SimpleSet<Integer> ss = new ru.moskalets.set.task1.SimpleSet<Integer>(10);
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