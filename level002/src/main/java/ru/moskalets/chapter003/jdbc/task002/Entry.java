package ru.moskalets.chapter003.jdbc.task002;

import javax.xml.bind.annotation.*;

/**
 * Класс реализует запись объект в который помещается запись из бд.
 */
@XmlRootElement(name = "entry")
public class Entry {
    /**
     * field.
     */
    private int field;

    /**
     * Конструктор.
     */
    public Entry() {
    }

    /**
     * Конструктор.
     * @param field
     */
    public Entry(int field) {
        this.field = field;
    }

    /**
     * Возвращает field.
     * @return
     */
    @XmlElement(name = "field")
    public int getField() {
        return this.field;
    }
}