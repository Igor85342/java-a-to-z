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
    public static void main(String[] arg) {
        new Thread(new Time(1)).start();
    }
    @Override
    public void run() {
        Thread countCharThread = new Thread(new CountChar("123456789123456789123456789123456789123456789123456789"));
        countCharThread.start();
        try {
            Thread.currentThread().sleep(this.time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countCharThread.interrupt();
    }
}
