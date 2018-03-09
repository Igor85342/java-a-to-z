package ru.moskalets.chapter2.threads.task1;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Класс тестируется класс Counter.
 */
public class CounterTest {
    @Test
    /**
     * Тест метода countingNumberSpaces.
     */
    public void countingNumberSpacesTest() {
        Counter counter = new Counter(" One two three four  five ");
        assertThat(counter.countingNumberSpaces(), is(7));
    }

    /**
     * Тест метода countingNumberWords.
     */
    @Test
    public void countingNumberWordsTest() {
        Counter counter = new Counter(" One two three four  five ");
        assertThat(counter.countingNamberWords(), is(5));
    }
}