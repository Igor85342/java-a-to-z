package ru.moskalets.chapter2.threads.task3;

/**
 * В классе Time работают две нити, одна считает сколько исполняется программа и если,
 * дольше заданного времени, то прекращает выполнение, вторая считает количество символов
 * в строке.
 */
public class Time implements Runnable {
    /**
     * time - предельное время работы программы.
     */
    private long time;

    /**
     * Конструктор.
     * @param time
     */
    public Time(long time) {
        this.time = time;
    }
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long end = start + this.time;
        try {
                Thread.sleep(this.time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.currentThread().interrupt();
    }
}
