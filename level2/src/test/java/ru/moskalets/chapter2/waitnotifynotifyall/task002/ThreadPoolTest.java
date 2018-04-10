package ru.moskalets.chapter2.waitnotifynotifyall.task002;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Класс тестирует класс ThreadPool.
 */
public class ThreadPoolTest {
    @Test
    /**
     * Тест добавляет несколько задач, которые выполняются разными потоками.
     */
    public void whenRunThreadPool() throws InterruptedException {
        ThreadPool tp = new ThreadPool();
       for (int i = 0; i < 10; i++) {
            tp.add(new Work());
        }
        tp.startThreadPool();
}
}