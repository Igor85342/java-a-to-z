package ru.moskalets.testtask.task3;

import java.util.*;

/**
 * EventStore - Класс реализовывает учет однотипных событий в системе.
 * События поступают в произвольный момент времени. Возможно как 10К событий в секунду так и 2 в час.
 */
public class EventStore {
    /**
     * minute - минута в миллисекундах.
     */
    private long minute = 60000;
    /**
     * hour - час в миллисекунадах.
     */
    private long hour = 3600000;
    /**
     * day - день в миллисекундах.
     */
    private long day =  864000000;
    /**
     * index - индекс события.
     */
    private int index = 0;
    /**
     * events - контейнер для событий.
     */
    private Map<Integer, Event> events = new LinkedHashMap<Integer, Event>();
    /**
     * Метод добавляет событие.
     */
    public void addEvent() {
        this.events.put(this.index++, new Event());
    }
    /**
     * Метод возвращает количество событий произошедщих за введенное время.
     * @param time
     * @return
     */
    public int returnEvents(long time) {
        long now = System.currentTimeMillis();
        long difference = now - time;
        int k = 1;
        ArrayDeque<Event> list = new ArrayDeque<Event>();
        Event tempEvent = this.events.get(this.index - k);
        while (tempEvent != null && tempEvent.getDate().getTime() > difference) {
            k++;
            list.addFirst(tempEvent);
            tempEvent = this.events.get(this.index - k);
        }
        return list.size();
    }

    /**
     * Метод возвращает количество событий за минуту.
     * @return
     */
    public int returnEventsForLastMinute() {
        int numberOfEvents = returnEvents(this.minute);
        return numberOfEvents;
    }

    /**
     * Метод возаращает количество событий за час.
     * @return
     */
    public int returnEventsForLastHour() {
        int numberOfEvents = returnEvents(this.hour);
        return numberOfEvents;
    }

    /**
     * Метод возвращает количество событий за сутки.
     * @return
     */
    public int returnEventsForLastDay() {
        int numberOfEvents = returnEvents(this.day);
        return numberOfEvents;
    }
}
