package ru.moskalets.testTask.task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class ReferenceUnits.
 * @author Igor Moskalets
 * @since 05.07.2017
 */
public class ReferenceUnitsTest {
    /**
     * Input receives a list, returns a sorted ascending list.
     */
    @Test
    public void whenUnsortedListReturnsSortedAscendingList(){
        ReferenceUnits refU = new ReferenceUnits();
        String[] array = new String[]{"k1\\sk1", "k1\\sk1\\ssk2", "k1\\sk2\\ssk1", "k2", "k2\\sk1\\ssk1", "k2\\sk2", "k2\\sk2\\ssk2",
                "k1", "k1\\sk1\\ssk1", "k1\\sk2", "k1\\sk2\\ssk2", "k2\\sk1", "k2\\sk1\\ssk2", "k2\\sk2\\ssk1",};
        List<String> result= refU.sortAscending(Arrays.asList(array));
        List<String> expected = Arrays.asList(new String[]{"k1", "k1\\sk1", "k1\\sk1\\ssk1", "k1\\sk1\\ssk2", "k1\\sk2", "k1\\sk2\\ssk1", "k1\\sk2\\ssk2",
                "k2", "k2\\sk1", "k2\\sk1\\ssk1", "k2\\sk1\\ssk2", "k2\\sk2", "k2\\sk2\\ssk1", "k2\\sk2\\ssk2"});
        assertThat(result, is(expected));
    }
    @Test
    /**
     * Input receives a list, returns a sorted descending list. The points get up earlier than their contents.
     */
    public void whenUnsortedListReturnsSortedDescendingList(){
        ReferenceUnits refU = new ReferenceUnits();
        String[] array = new String[]{"k1\\sk1", "k1\\sk1\\ssk2", "k1\\sk2\\ssk1", "k1", "k2\\sk1\\ssk1", "k2\\sk2", "k2\\sk2\\ssk2",
                "k2", "k1\\sk1\\ssk1", "k1\\sk2", "k1\\sk2\\ssk2", "k2\\sk1", "k2\\sk1\\ssk2", "k2\\sk2\\ssk1"};
        List<String> result= refU.sortDescending(Arrays.asList(array));
        List<String> expected = Arrays.asList(new String[]{"k2", "k2\\sk2", "k2\\sk2\\ssk2", "k2\\sk2\\ssk1", "k2\\sk1", "k2\\sk1\\ssk2", "k2\\sk1\\ssk1", "k1",
                "k1\\sk2", "k1\\sk2\\ssk2", "k1\\sk2\\ssk1", "k1\\sk1", "k1\\sk1\\ssk2", "k1\\sk1\\ssk1"});
        assertThat(result, is(expected));
    }
}
