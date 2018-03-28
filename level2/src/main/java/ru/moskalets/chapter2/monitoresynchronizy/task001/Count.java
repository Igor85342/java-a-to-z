package ru.moskalets.chapter2.monitoresynchronizy.task001;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Класс count.
 */
@ThreadSafe
public class Count {
    /**
     * value
     */
    @GuardedBy("this")
    private int value;

    /**
     * Увеличвивает на 1 value.
     */
    public synchronized void increment() {
        this.value++;
    }

    /**
     * Возвращает value.
     * @return
     */
    public synchronized int get() {
        return this.value;
    }
}
