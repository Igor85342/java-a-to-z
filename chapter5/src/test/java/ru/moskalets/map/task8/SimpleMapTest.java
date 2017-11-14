package ru.moskalets.map.task8;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Testing the class SimpleMap.
 */
public class SimpleMapTest {
    /**
     * The collection adds a single element, returns true.
     */
    @Test
    public void whenAddOneElementReturnsTrue() {
        SimpleMap<Integer, String> sm = new SimpleMap();
        boolean result = sm.insert(1, "First");
        assertThat(result, is(true));
    }

    /**
     * The collection adds two elements called the second element, it returns the value of the second element.
     */
    @Test
    public void whenSomeItemsAreAddedAndIsGetSecondReturnsTheSecondValueElement() {
        SimpleMap<Integer, String> sm = new SimpleMap();
        sm.insert(1, "First");
        sm.insert(2, "Second");
        assertThat(sm.get(2), is("Second"));
    }

    /**
     * The collection adds two elements with the same key, it returns false.
     */
    @Test
    public void whenAddAnElementWithAnExistingKeyReturnsFalse() {
        SimpleMap<Integer, String> sm = new SimpleMap();
        sm.insert(1, "First");
        boolean result = sm.insert(1, "Second");
        assertThat(result, is(false));
    }

    /**
     * The collection adds three elements , the second is removed, returns true.
     */
    @Test
    public void whenRemovedElementReturnsTrue() {
        SimpleMap<Integer, String> sm = new SimpleMap();
        sm.insert(1, "First");
        sm.insert(2, "Second");
        sm.insert(3, "Third");
        boolean result = sm.delete(2);
        assertThat(result, is(true));
    }

    /**
     *Tests the iterator is added to the five elements, the iterator moves 3 times, it returns the third element.
     */
    @Test
    public void testNextSimpleMapIterator() {
        SimpleMap<Integer, Integer> sm = new SimpleMap();
        sm.insert(1, 1);
        sm.insert(2, 2);
        sm.insert(3, 3);
        sm.insert(4, 4);
        Iterator iter = sm.iterator();
        iter.next();
        iter.next();
        Entry result = (Entry) iter.next();
        assertThat(result.getValue(), is(3));
    }

    /**
     *You are testing an iterator that adds three elements, the iterator moves 2 times,
     *  invoked method hasNext returns true.
     */
    @Test
    public void testHasNextSimpleMapIteratorReturnTrue() {
        SimpleMap<Integer, Integer> sm = new SimpleMap();
        sm.insert(1, 1);
        sm.insert(2, 2);
        sm.insert(3, 3);
        Iterator iter = sm.iterator();
        iter.next();
        iter.next();
        iter.hasNext();
        boolean result = iter.hasNext();
        assertThat(result, is(true));
    }

    /**
     * You are testing an iterator that adds three elements, the iterator moves 3 times,
     * invoked method hasNext returns false.
     */
    @Test
    public void testHasNextSimpleMapIteratorReturnFalse() {
        SimpleMap<Integer, Integer> sm = new SimpleMap();
        sm.insert(1, 1);
        sm.insert(2, 2);
        sm.insert(3, 3);
        Iterator iter = sm.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.hasNext();
        boolean result = iter.hasNext();
        assertThat(result, is(false));
    }
}