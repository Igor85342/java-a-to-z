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
    public static void main(String[] args) {
        new Thread(new Time(5000)).start();
    }
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long end = start + this.time;
        Thread threadCountChar = new Thread(new CountChar("asdfafsafdasdf"));
        threadCountChar.start();
        while (threadCountChar.isAlive() && System.currentTimeMillis() < end) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
