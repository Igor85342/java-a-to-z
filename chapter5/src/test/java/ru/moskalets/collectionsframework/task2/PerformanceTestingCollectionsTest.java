package ru.moskalets.collectionsframework.task2;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
        assertThat(ptc.getArrayList().size(), is(990000));
        assertThat(ptc.getLinkedList().size(), is(990000));
        assertThat(ptc.getTreeSet().size(), is(990000));
    }
}
