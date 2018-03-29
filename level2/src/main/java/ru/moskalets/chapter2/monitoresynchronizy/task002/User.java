package ru.moskalets.chapter2.monitoresynchronizy.task002;

/**
 * Класс User.
 */
public class User {
    /**
     * id.
     */
    private final int id;
    /**
     * amount.
     */
    private int amount;

    /**
     * Конструктор.
     * @param id
     * @param amount
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Возвращает id.
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     * Возвращает amount.
     * @return
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Заменяет amount.
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
