package ru.moskalets.chapter2.waitnotifynotifyall.task002;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ThreadPool реализует пул потоков.
 */
@ThreadSafe
public class ThreadPool {
    /**
     * works - лист задач.
     */
    @GuardedBy("this")
    private Queue<Work> works = new LinkedList<>();
    /**
     * threads - массив потоков.
     */
    private Thread[] threads;
    /**
     * finish
     */
    private boolean finish = false;

    /**
     * Конструктор.
     */
    public ThreadPool() {
        int core = Runtime.getRuntime().availableProcessors();
        this.threads = new Thread[core];
        for (int i = 0; i < core; i++) {
            new WorkingThread().start();
        }
    }
    /**
     * Добавляет задачу.
     * @param work - задача.
     */
    public void add(Work work) {
        synchronized (this) {
            this.works.add(work);
            notifyAll();
        }
    }
    /**
     * Проверяет, если задачи в листе.
     * @return
     */
    public boolean isEmpty() {
        synchronized (this) {
            return this.works.isEmpty();
        }
    }
    /**
     * Удаляет первую задачу.
     * @return
     */
    public Work pool() {
        synchronized (this) {
            return this.works.poll();
        }
    }
    /**
     * Заканчивает работу.
     */
    public void finish() {
        this.finish = true;
    }
    /**
     * Класс нить, которая обрабатывает задачи из списка.
     */
   private class WorkingThread extends Thread {
        @Override
        public void run() {
            synchronized (ThreadPool.this) {
                while (!ThreadPool.this.finish) {
                    while (ThreadPool.this.isEmpty()) {
                        try {
                            ThreadPool.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Work work = ThreadPool.this.pool();
                    if (work != null) {
                        work.run();
                    }
                    System.out.println("Thread " + Thread.currentThread().getId() + " executed work");
                }
            }
        }
    }
}
