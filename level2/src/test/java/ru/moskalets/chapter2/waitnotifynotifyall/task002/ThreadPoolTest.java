package ru.moskalets.chapter2.waitnotifynotifyall.task002;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Класс тестирует класс ThreadPool.
 */
public class ThreadPoolTest {
    @Test
    /**
     * Тест добавляет несколько задач, которые выполняются разными потоками из пула потоков.
     */
    public void whenRunThreadPool() throws InterruptedException {
        ThreadPool tp = new ThreadPool();
       for (int i = 0; i < 100; i++) {
            tp.add(new Work());
        }
       Thread.currentThread().sleep(100);
       tp.finish();
    }
}