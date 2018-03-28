package ru.moskalets.chapter2.jmm.task001;

/**
 * Класс RaceCondition иллюстрирует проблему race condition при написании
 * многопоточного приложения.
 */
public class RaceCondition {
    /**
     *
     */
    private int x = 0;
    public static void main(String[] args) {
        RaceCondition rc = new RaceCondition();
        new Thread() {
            @Override
            public void run() {
                System.out.println("Even - " + rc.even());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println("Uneven - " + rc.uneven());
            }
        }.start();
    }
    /**
     * Метод считает нечетные числа.
     * @return
     */
    public int uneven() {
        int uneven = 0;
        for (int i = 0; i < 100000; i++) {
            if (this.x % 2 != 0) {
                uneven++;
            }
            this.x++;
        }
        return uneven;
    }

    /**
     * Метод считает четные числа.
     * @return
     */
    public int even() {
        int even = 0;
        for (int i = 0; i < 100000; i++) {
           if (this.x % 2 == 0) {
               even++;
           }
            this.x++;
        }
        return even;
    }
}
