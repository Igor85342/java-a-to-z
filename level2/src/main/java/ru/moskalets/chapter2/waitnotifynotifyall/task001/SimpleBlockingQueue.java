package ru.moskalets.chapter2.waitnotifynotifyall.task001;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Этот класс реализует bounded blocking queue.
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    /**
     * queue
     */
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<T>();
    /**
     * capacity - размер очереди.
     */
    private int capacity;

    /**
     * Конструктор, задается размер.
     * @param capacity
     */
    public SimpleBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Добавление элемента. Если количество элементов становиться равно размеру, нить переходит в ждущие состояние.
     * @param value
     * @throws InterruptedException
     */
    public void offer(T value) throws InterruptedException {
        synchronized (this) {
            while (this.queue.size() == this.capacity) {
                wait();
            }
            queue.add(value);
            notify();
        }
    }

    /**
     * Удаление верхушки очереди. Если очередь пуста, нить переходит в ждущее состояние.
     * @return
     * @throws InterruptedException
     */
    public T poll() throws InterruptedException {
        synchronized (this) {
            while (queue.isEmpty()) {
                wait();
            }
            notify();
            return this.queue.poll();
        }
    }

    /**
     * Возвращает queue.
     * @return
     */
    public Queue<T> getQueue() {
        synchronized (this) {
            return this.queue;
        }
    }
}
