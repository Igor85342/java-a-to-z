package ru.moskalets.chapter001.list.task004;

/**
 * Класс реализует элемент стека и очереди.
 * @param <T>
 */
public class Node<T> {
    /**
     * value.
     */
    private T value;
    /**
     * prev
     */
    private Node<T> prev;
    /**
     * next
     */
    private Node<T> next;

    /**
     * Конструктор.
     * @param value
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Конструктор.
     * @param value
     * @param prev
     */
    public Node(T value, Node<T> prev) {
        this.value = value;
        this.prev = prev;
    }

    /**
     * Добавить ссылку на следущий элемент.
     * @param node
     */
    public void setNext(Node<T> node) {
        this.next = node;
    }

    /**
     * Добавить ссылку на предыдущий элемент.
     * @param node
     */
    public void setPrev(Node<T> node) {
        this.prev = prev;
    }

    /**
     * Вернуть значение элемента.
     * @return
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Вернуть ссылку на предыдущий элеметн.
     * @return
     */
    public Node getPrev() {
        return this.prev;
    }
}