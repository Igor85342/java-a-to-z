package ru.moskalets.chapter2.waitnotifynotifyall.task003;

/**
 * Класс увеличивает счетчик на единицу. Использует блокировку SimpleLock
 */
public class Counter {
    private SimpleLock simpleLock = new SimpleLock();
    private int count = 0;

    /**
     * Увеличивает счетчик на единицу.
     * @throws InterruptedException
     */
    public void increaseCounter() throws InterruptedException {
        simpleLock.lock();
        count++;
        simpleLock.unlock();
    }
    /**
     * Возвращает count.
     */
    public int getCount() {
        return this.count;
    }
}
