package ru.moskalets.iterator.task1;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the method IteratorTwodimesionalArray.
 * @author Igor Moskalets
 * @since 30.07.2017
 */
public class IteratorTwodimensionalArrayTest {
    /**
     * In the test four times invoked the next() method and the result is the fourth element of the array.
     */
    @Test
    public void whenGetNextCallShouldPointerForward() {
        IteratorTwodimensionalArray ita = new IteratorTwodimensionalArray(new int[][]{{0, 1}, {2, 3}});
        ita.next();
        ita.next();
        ita.next();
        int result = (Integer) ita.next();
        assertThat(result, is(3));
    }
    /**
     * In this test, the command first calls the last element,
     * and then checks whether there are still elements.
     * The method returns "false". Method hasNext() is called twice.
     */
    @Test
    public void whenCheckNextPositionShouldReturnContantValue() {
        IteratorTwodimensionalArray ita = new IteratorTwodimensionalArray(new int[][]{{0, 1}, {2, 3}});
        ita.next();
        ita.next();
        ita.next();
        ita.next();
        ita.hasNext();
        boolean result = ita.hasNext();
        assertThat(result, is(false));
    }
}