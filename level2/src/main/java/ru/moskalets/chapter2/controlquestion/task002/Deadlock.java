package ru.moskalets.chapter2.controlquestion.task002;

/**
 * В классе реализован гарантированный DeadLock.
 */
public class Deadlock {
    private final Thread mainThread;
    public Deadlock() {
        this.mainThread = Thread.currentThread();
    }
    public static void main(String[] args) {
        Deadlock dl = new Deadlock();
        dl.init();
    }
    public void init() {
        Thread thread001 = new Thread() {
            @Override
            public void run() {
                try {
                    Deadlock.this.mainThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        thread001.start();
        try {
            thread001.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}