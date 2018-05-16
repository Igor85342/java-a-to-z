package ru.moskalets.chapter2.controlquestion.task002;

/**
 * В классе реализован гарантированный DeadLock.
 */
public class Deadlock {
    private Object lock001 = new Object();
    private Object lock002 = new Object();
    public static void main(String[] args) {
        Deadlock dl = new Deadlock();
        dl.init();
    }
    public void init() {
        Thread thread001 = new Thread() {
            @Override
            public void run() {
                synchronized (Deadlock.this.lock001) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (Deadlock.this.lock002) {
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock002.notify();
                    }
                    lock001.notify();
                }
            }
        };
        Thread thread002 = new Thread() {
            @Override
            public void run() {
                synchronized (Deadlock.this.lock002) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (Deadlock.this.lock001) {
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        lock001.notify();
                    }
                    lock002.notify();
                }
            }
        };
        thread001.start();
        thread002.start();
    }
}