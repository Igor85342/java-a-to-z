package ru.moskalets.iterator.task3;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
/**
 * Testing the method IteratorPrimeNumbers.
 * @author Igor Moskalets
 * @since 01.08.2017
 */
public class IteratorPrimeNumbersTest {
    /**
     * This test checks the call to the next Prime number. The call occurs five times.
     */
    @Test
    public void whenHappensNextCallReturnsPrimenumberedElement(){
        IteratorPrimeNumbers ipn = new IteratorPrimeNumbers(new int[]{1,2,3,4,5,6,7});
        ipn.next();
        ipn.next();
        ipn.next();
        ipn.next();
        int result = (Integer)ipn.next();
        assertThat(result, is(7));
    }
    /**
     * This test checks whether the array is a Prime number and returns true.
     */
    @Test
    public void whenArrayHasAnPrimeNumberAfterPointerReturnsTrue(){
        IteratorPrimeNumbers ipn = new IteratorPrimeNumbers(new int[] {7,6,4,5,2,1,3});
        ipn.next();
        ipn.next();
        ipn.hasNext();
        boolean result = ipn.hasNext();
        assertThat(result, is(true));
    }
    /**
     * This test checks whether the array is a Prime number and returns false.
     */
    @Test
    public void whenArrayHasNoPrimeNumbersAfterPointerReturnsFalse(){
        IteratorPrimeNumbers ipn = new IteratorPrimeNumbers(new int[] {7,6,4,5,10,12,15});
        ipn.next();
        ipn.next();
        ipn.hasNext();
        boolean result = ipn.hasNext();
        assertThat(result, is(false));
    }
    /**
     * This test checks whether a number is Prime, and returns "true".
     */
    @Test
    public void whenPrimeNumberReturnsTrue(){
        IteratorPrimeNumbers ipn = new IteratorPrimeNumbers(new int[] {7,6,4,5,10,12,15});
        boolean result =ipn.thisPrimeNumber(2);
        assertThat(result, is(true));
    }
    /**
     * This test checks whether a number is Prime, and returns "false".
     */
    @Test
    public void whenCompositeNumberReturnsFalse(){
        IteratorPrimeNumbers ipn = new IteratorPrimeNumbers(new int[] {7,6,4,5,10,12,15});
        boolean result =ipn.thisPrimeNumber(4);
        assertThat(result, is(false));
    }
}