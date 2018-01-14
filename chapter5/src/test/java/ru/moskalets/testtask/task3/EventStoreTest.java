package ru.moskalets.testtask.task3;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

/**
 * Класс тестирует класс EventStore.
 */
public class EventStoreTest {
    /**
     * Провяерятются методы returnEventsForLastMinute(), returnEventsForLastHour(), returnEventsForLastDay().
     * Добавляются три события, а затем возвращется количество событий за последнию минуту, час, 24 часа.
     */
    @Test
    public void addedThreeEventsArePrintedThreeEvents() {
            EventStore es = new EventStore();
            es.addEvent();
            es.addEvent();
            es.addEvent();
            int result = es.returnEventsForLastMinute();
            int result2 = es.returnEventsForLastHour();
            int result3 = es.returnEventsForLastDay();
            assertThat(result, is(3));
            assertThat(result2, is(3));
            assertThat(result3, is(3));
    }
    /**
     * Провяерятются методы returnEventsForLastMinute(), returnEventsForLastHour(), returnEventsForLastDay().
     * Добавляется событие, далее задержка по времени на минуту, далее еще два события,
     * а затем возвращется количество событий за последнию минуту, час, 24 часа.
     * За минуту - 2 события.
     * За час - 3 события.
     * За 24 часа - 3 события.
     */
    @Test
    public void addedThreeEventsArePrintedTwoEvents() {
        try {
            EventStore es = new EventStore();
            es.addEvent();
            Thread.sleep(60000);
            es.addEvent();
            es.addEvent();
            int result = es.returnEventsForLastMinute();
            int result2 = es.returnEventsForLastHour();
            int result3 = es.returnEventsForLastDay();
            assertThat(result, is(2));
            assertThat(result2, is(3));
            assertThat(result3, is(3));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}