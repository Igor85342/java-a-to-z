package ru.moskalets.chapter2.waitnotifynotifyall.task002;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ThreadPool реализует пул потоков.
 */
@ThreadSafe
public class ThreadPool {
    @GuardedBy("this")
    /**
     * works - лист задач.
     */
    private Queue<Work> works = new LinkedList<>();
    /**
     * threads - массив потоков.
     */
    private Thread[] threads;

    /**
     * Метод иницилизирует количество потоков равное количеству ядер процессора. Доблавляет эти потоки в массив и
     * запускает их.
     * @throws InterruptedException
     */
    public void startThreadPool() throws InterruptedException {
        int core = Runtime.getRuntime().availableProcessors();
        this.threads = new Thread[core];
        for (int i = 0; i < core; i++) {
            new WorkingThread().start();
        }
        Thread.currentThread().sleep(100);
    }

    /**
     * Добавляет задачу.
     * @param work - задача.
     */
    public void add(Work work) {
        synchronized (this) {
            this.works.add(work);
            notify();
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
     * Класс нить, которая обрабатывает задачи из списка.
     */
   private class WorkingThread extends Thread {
        @Override
        public void run() {
            synchronized (this) {
                while (true) {
                    while (ThreadPool.this.isEmpty()) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Work work = ThreadPool.this.pool();
                    try {
                        Thread.currentThread().sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (work != null) {
                        work.run();
                    }
                    System.out.println("Thread " + Thread.currentThread().getId() + " executed work");
                }
            }
        }
    }
}
