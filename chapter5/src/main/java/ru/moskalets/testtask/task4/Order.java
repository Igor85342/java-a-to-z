package ru.moskalets.testtask.task4;

/**
 * Класс реализует заявку.
 */
public class Order {
    /**
     * book - наименоване ценной бумаги.
     */
    private String book;
    /**
     * оperation - операция с ценной бумагой.
     */
    private String operation;
    /**
     * price - цена.
     */
    private double price;
    /**
     * volume - количество.
     */
    private int volume;
    /**
     * orderId - номер заявки.
     */
    private int orderId;

    /**
     * Конструктор.
     * @param book
     * @param operation
     * @param price
     * @param volume
     * @param orderId
     */
    public Order(String book, String operation, double price, int volume, int orderId) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.orderId = orderId;
    }

    /**
     * Возвращает наименование ценной бумаги.
     * @return
     */
    public String getBook() {
        return this.book;
    }

    /**
     * Возвращает операцию.
     * @return
     */
    public String getOperation() {
        return this.operation;
    }

    /**
     * Возвращают цену.
     * @return
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Возвращает количество.
     * @return
     */
    public int getVolume() {
        return this.volume;
    }

    /**
     * Возвращает id.
     * @return
     */
    public int getOrderId() {
        return this.orderId;
    }

    /**
     * Изменяет количество.
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }
}
