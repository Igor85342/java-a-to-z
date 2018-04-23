package ru.moskalets.chapter2.waitnotifynotifyall.task003;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Класс реализует механизм блокировок.
 */
@ThreadSafe
public class SimpleLock {
    /*
    lockIsFree - флаг, заблокирован ли лок.
     */
    @GuardedBy("this")
    private boolean lockIsFree = true;
    /*
    thread - текущий поток.
     */
    private Thread thread;
    /*
    Проверяет свободен ли lock, иначе блокирует.
     */
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (!lockIsFree) {
                wait();
            }
            this.thread = Thread.currentThread();
            this.lockIsFree = false;
        }
    }
    /*
    Проверяет владеет ли потоком Lock, если да, то освобождает.
     */
    public void unlock() {
        synchronized (this) {
            if (this.thread == Thread.currentThread()) {
                lockIsFree = true;
                notifyAll();
            }
        }
    }


}
