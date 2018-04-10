package ru.moskalets.chapter2.waitnotifynotifyall.task003;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
/**
 * Тестирует класс Counter.
 */
public class CounterTest {
    /*
    *Тест запускает два потока, которые увеличиваеют один счетчик каждый 1000 раз. В результате
    *возвращается значение 2000.
    */
    @Test
    public void whenTwoThreadRunCounterThenTheyWorkConsistently()  {
        Counter counter = new Counter();
        Runnable runnable = new Runnable() {
            @Override
            public void run()  {
                for (int i = 0; i < 1000; i++) {
                    try {
                        counter.increaseCounter();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        Thread thread001 = new Thread(runnable);
        Thread thread002 = new Thread(runnable);
        thread001.start();
        thread002.start();
        try {
            thread001.join();
            thread002.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertThat(counter.getCount(), is(2000));
    }
}