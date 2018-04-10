package ru.moskalets.chapter2.waitnotifynotifyall.task003;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Класс реализует механизм блокировок.
 */
@ThreadSafe
public class SimpleLock {
    @GuardedBy("this")
    private boolean lockIsFree = true;
    /*
    Проверяет свободен ли lock, иначе блокирует.
     */
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (!lockIsFree) {
                wait();
            }
            this.lockIsFree = false;
        }
    }
    /*
    Проверяет владеет ли потоком Lock, если да, то  освобождает.
     */
    public void unlock() {
        synchronized (this) {
            lockIsFree = true;
            notify();
        }
    }


}
