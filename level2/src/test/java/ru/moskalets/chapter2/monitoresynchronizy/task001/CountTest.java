package ru.moskalets.chapter2.monitoresynchronizy.task001;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Тест для класса Count.
 */
public class CountTest {
    /**
     * Класс описывает нить со счетчиком.
     */
    private class ThreadCount extends Thread {
        /**
         * count.
         */
        private final Count count;

        /**
         * Конструктор.
         * @param count
         */
        private ThreadCount(final Count count) {
            this.count = count;
        }
        @Override
        public void run() {
            this.count.increment();
        }
    }

    /**
     * Проверяет выполнение двух потоков. Возвращает 2.
     * @throws InterruptedException
     */
    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        //Создаем счетчик.
        final Count count = new Count();
        //Создаем нити.
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        //Запускаем нити.
        first.start();
        second.start();
        //Заставляем главную нить дождаться выполнения наших нитей.
        first.join();
        second.join();
        //Проверяем результат.
        assertThat(count.get(), is(2));

    }
}