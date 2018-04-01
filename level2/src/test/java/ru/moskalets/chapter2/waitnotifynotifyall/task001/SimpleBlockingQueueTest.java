package ru.moskalets.chapter2.waitnotifynotifyall.task001;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Класс тестирует SimpleBlockingQueue.
 */
public class SimpleBlockingQueueTest {
    /**
     * Добавляет два элемента в первом потоке, второй поток удаляет первый элемент. Второй поток ждет выполение первого.
     * Возвращает второй элемент.
     * @throws InterruptedException
     */
    @Test
    public void whenProducerAddTweElementsAndConsumerDeleteElementThanWillBeSecondElement() throws InterruptedException {
        SimpleBlockingQueue<Integer> sbq = new SimpleBlockingQueue<>(10);
        Thread producer = new Thread() {
            @Override
            public void run() {
                try {
                    sbq.offer(1);
                    sbq.offer(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread consumer = new Thread() {
            @Override
            public void run() {
                try {
                    sbq.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        producer.start();
        producer.join();
        consumer.start();
        consumer.join();
        assertThat(sbq.getQueue().element(), is(2));
    }
}