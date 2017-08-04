package ru.moskalets.iterator.task2;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
/**
 * Testing the method IteratorEvenNumbers.
 * @author Igor Moskalets
 * @since 01.08.2017
 */
public class IteratorEvenNumbersTest {
    /**
     * This test is called three times the next() method
     * and finally the third result is an even number in the array.
     */
    @Test
    public void whenHappensNextCallReturnsEvennumberedElement(){
        IteratorEvenNumbers ien = new IteratorEvenNumbers(new int[]{2,5,7,9,10,14,3});
        ien.next();
        ien.next();
        int result = (Integer)ien.next();
        assertThat(result, is(14));
    }
    /**
     * TThis test checks whether the array after the pointer is an even number, and returns true.
     */
    @Test
    public void WhenArrayHasAnEvenNumberAfterPointerReturnsTrue(){
        IteratorEvenNumbers ien = new IteratorEvenNumbers(new int[]{2,5,7,9,10,14,3,2});
        ien.next();
        ien.next();
        ien.next();
        ien.hasNext();
        boolean result = ien.hasNext();
        assertThat(result,is(true));
    }
    /**
     * This test checks whether the array is an even number, and returns false.
     */
    @Test
    public void WhenArrayHasNoEvenNumbersAfterPointerReturnsFalse(){
        IteratorEvenNumbers ien = new IteratorEvenNumbers(new int[]{2,5,7,9,10,14,3});
        ien.next();
        ien.next();
        ien.next();
        ien.hasNext();
        boolean result = ien.hasNext();
        assertThat(result,is(false));
    }
}