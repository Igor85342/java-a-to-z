package ru.moskalets.chapter2.jmm.task001;

/**
 * Класс  VisibilityProblem иллюстрирует проблему видимости изменений сделанных
 * одним потоком в общих данных для других потоков.
 */
public class VisibilityProblem {
    /**
     * count.
     */
    private int count = 10;
    public static void main(String[] args) {
        VisibilityProblem vp = new VisibilityProblem();
        Thread thread001 = new Thread() {
            @Override
            public void run() {
                vp.increaseCounter();
            }
        };
        Thread thread002 = new Thread() {
            @Override
            public void run() {
                vp.reducingCounter();
            }
        };
        Thread thread003 = new Thread() {
            @Override
            public void run() {
                System.out.println(vp.count);
            }
        };
        thread001.start();
        thread002.start();
        thread003.start();
        try {
            thread003.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Увеличивает счетчик в 10 раз.
     */
    public void increaseCounter() {
        this.count = this.count * 10;
    }

    /**
     * Уменьшает счетчик на 5.
     */
    public void reducingCounter() {
        this.count = this.count - 5;
    }

    /**
     * Возвращает count.
     * @return
     */
    public int getCount() {
        return this.count;
    }
}
