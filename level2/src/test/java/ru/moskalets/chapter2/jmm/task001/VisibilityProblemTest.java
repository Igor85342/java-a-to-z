package ru.moskalets.chapter2.jmm.task001;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Данный класс тестирует класс VisibilityProblem.
 */
public class VisibilityProblemTest {
    /**
     * Тест метода increaseCounter().
     * @throws Exception
     */
    @Test
    public void increaseCounterTest() throws Exception {
        VisibilityProblem vp = new VisibilityProblem();
        vp.increaseCounter();
        assertThat(vp.getCount(), is(100));
    }

    /**
     * Тест метода reducingCounter().
     * @throws Exception
     */
    @Test
    public void reducingCounterTest() throws Exception {
        VisibilityProblem vp = new VisibilityProblem();
        vp.reducingCounter();
        assertThat(vp.getCount(), is(5));
    }

}