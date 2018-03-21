package ru.moskalets.chapter2.threads.task2;

import org.junit.Test;
import ru.moskalets.chapter2.threads.task1.Counter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестируется класс Counter.
 */
public class CounterTest {
    @Test
    /**
     * Тест метода countingNumberSpaces.
     */
    public void countingNumberSpacesTest() {
        ru.moskalets.chapter2.threads.task1.Counter counter = new ru.moskalets.chapter2.threads.task1.Counter(" One two three four  five ");
        assertThat(counter.countingNumberSpaces(), is(7));
    }

    /**
     * Тест метода countingNumberWords.
     */
    @Test
    public void countingNumberWordsTest() {
        ru.moskalets.chapter2.threads.task1.Counter counter = new Counter(" One two three four  five ");
        assertThat(counter.countingNamberWords(), is(5));
    }
}