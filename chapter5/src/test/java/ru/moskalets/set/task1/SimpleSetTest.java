package ru.moskalets.set.task1;

import org.junit.Test;
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
}