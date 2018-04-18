package ru.moskalets.chapter2.nonblockingalgoritm.task001;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Тест для класса NonBlockingCashe.
 */
public class NonBlockingCacheTest {
    /**
     * Запускает 20 потоков измениющих один элемент.
     */
    @Test
    public void whenRunTwentyThreadsMakingUpdate() {
        NonBlockingCache nbc = new NonBlockingCache();
        nbc.add(1);
        for (int i = 0; i < 20; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        nbc.update(1, new Model());
                    } catch (OplimisticException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        try {
            Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * Добавляет два элемента, возвращает размер равный двум.
     */
    @Test
    public void whenAddTwoElementsThanSizeContainerTwo() {
        NonBlockingCache nbc = new NonBlockingCache();
        nbc.add(1);
        nbc.add(2);
        assertThat(nbc.getContainer().size(), is(2));
    }
    /**
     * Добавляет два элемента,один удаляет, возвращает размер равный одному.
     */
    @Test
    public void whenAddTwoElementsAndDeleteOneThanSizeContainerOne() {
        NonBlockingCache nbc = new NonBlockingCache();
        nbc.add(1);
        nbc.add(2);
        nbc.delete(1);
        assertThat(nbc.getContainer().size(), is(1));
    }
}