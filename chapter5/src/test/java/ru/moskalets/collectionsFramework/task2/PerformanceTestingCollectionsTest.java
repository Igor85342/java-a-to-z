package ru.moskalets.collectionsFramework.task2;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * PerformanceTestingCollectionsTest - Testing the method PerformanceTestingCollections.
 * @author Igor Moskalets
 * @since 04.06.2017
 */
public class PerformanceTestingCollectionsTest {
    /**
     * This test checks the number of items in the collections after the creation and removal of elements.
     */
    @Test
    public void returnTotalNumberOfElementsInLists() {
        PerformanceTestingCollections ptc = new PerformanceTestingCollections();
        ptc.runPerformanceTestingCollections();
        assertThat(ptc.collectionsArrayList.size(), is(990000));
        assertThat(ptc.collectionsLinkedList.size(), is(990000));
        assertThat(ptc.collectionsTreeSet.size(), is(990000));
    }
}
