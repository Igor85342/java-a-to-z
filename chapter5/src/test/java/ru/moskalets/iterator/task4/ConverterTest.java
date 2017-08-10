package ru.moskalets.iterator.task4;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Created by Пользователь on 06.08.2017.
 */
public class ConverterTest {
    /**
     * The test checks the return element from the second iterator.
     */
    @Test
    public void whenSelectElementSecondIteratorReturnsElement() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
               Collections.singletonList(1).iterator(),
                Collections.singletonList(2).iterator(),
                Collections.singletonList(3).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        int result = convert.next();
        assertThat(result, is(2));
    }
    /**
     * Test checks whether there are more elements in the iterator and returns true.
     */
    @Test
    public void whenIteratorHasElementsReturnsTrue() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(2).iterator(),
                Collections.singletonList(3).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        convert.next();
        convert.hasNext();
        boolean result = convert.hasNext();
        assertThat(result, is(true));
    }
    /**
     * Test checks the case when the iterator is nested in one the iterator is the next item. Then returns "true".
     */
    @Test
    public void whenIteratorInOneNestedIteratorReturnsTrue(){
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        convert.hasNext();
        boolean result = convert.hasNext();
        assertThat(result, is(true));
    }
    /**
     * Test checks the case when the iterator is nested in one iterator and following item no. Then it returns "false".
     */
    @Test
    public void whenIteratorInOneNestedIteratorReturnsFalse(){
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        convert.hasNext();
        boolean result = convert.hasNext();
        assertThat(result, is(false));
    }
    /**
     * Test checks whether there are more elements in the iterator and returns false.
     */
    @Test
    public void whenIteratorNoElementsReturnsFalse() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(2).iterator(),
                Collections.singletonList(3).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        convert.next();
        convert.next();
        convert.next();
        convert.hasNext();
        boolean result = convert.hasNext();
        assertThat(result, is(false));
    }
}