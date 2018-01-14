package ru.moskalets.testtask.task3;

import java.util.Date;

/**
 * Event - класс реализующий событие.
 */
public class Event {
    /**
     * date - время события.
     */
    private Date date;
    /**
     * Констурктор.
     */
    public Event() {
        this.date = new Date();
    }
    /**
     * Возвращает время события.
     * @return
     */
    public Date getDate() {
        return this.date;
    }
}
