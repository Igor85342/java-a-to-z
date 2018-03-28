package ru.moskalets.chapter2.jmm.task001;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Класс RaceConditionTest тестирует класс RaceCondition.
 */
public class RaceConditionTest {
    /**
     * Подсчитывает количество четных чисел.
     */
    @Test
    public void evenTest() {
        RaceCondition rc = new RaceCondition();
        assertThat(rc.even(), is(50000));
    }

    /**
     * Подсчитывает количество нечетных чисел.
     */
    @Test
    public void unevenTest() {
        RaceCondition rc = new RaceCondition();
        assertThat(rc.uneven(), is(50000));
    }
}