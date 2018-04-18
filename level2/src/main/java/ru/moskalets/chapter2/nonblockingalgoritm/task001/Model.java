package ru.moskalets.chapter2.nonblockingalgoritm.task001;

/**
 * Модель
 */
public class Model {
    /**
     * version - версия.
     */
    private volatile int version = 0;
    /**
     * id.
     */
    private int id;
    /**
     * Конструктор.
     */
    public Model() {
    }
    /**
     * Конструктор.
     * @param id
     */
    public Model(int id) {
        this.id = id;
    }
    /**
     * Возвращает version.
     * @return
     */
    public int getVersion() {
        return this.version;
    }
    /**
     * Возвращает id.
     * @return
     */
    public int getId() {
        return this.id;
    }
    /**
     * Заполняет id.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Заполняет version.
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }
}
