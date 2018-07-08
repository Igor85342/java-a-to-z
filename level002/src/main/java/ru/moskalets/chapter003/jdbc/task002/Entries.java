package ru.moskalets.chapter003.jdbc.task002;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement(name = "entries")
/**
 * Класс содержит список объектов Entry.
 */
public class Entries {
    /**
     * entries.
     */
    private ArrayList<Entry> entries = new ArrayList<Entry>();

    /**
     * Добавляет элемент Entry.
     * @param entry
     */
    public void add(Entry entry) {
        this.entries.add(entry);
    }
    @XmlElement(name = "entry")
    /**
     * Возвращает список объектов Entry.
     */
    public ArrayList<Entry> getList() {
        return this.entries;
    }
}