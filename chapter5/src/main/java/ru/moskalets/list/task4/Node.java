package ru.moskalets.list.task4;

/**
 * A class implements an element of the collection.
 * author Igor Moskalets
 * Since 08.09.2017
 * @param <T>
 */
public class Node<T> {
    /**
     * The value of the item.
     */
    private T value;
    /**
     * Previous element.
     */
    private Node<T> prev;
    /**
     * Next element.
     */
    private Node<T> next;

    /**
     * Constructor.
     * @param value .
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Constructor.
     * @param prev .
     * @param value .
     */
    public Node(Node prev, T value) {
        this.prev = prev;
        this.value = value;
    }

    /**
     * Fills the value of the next element.
     * @param next .
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Returns the next element.
     * @param <T> .
     * @return T.
     */
    public <T> Node getNext() {
        return this.next;
    }

    /**
     * Returns the previous element.
     * @param <T> .
     * @return .
     */
    public <T> Node getPrev() {
        return this.prev;
    }
    /**
     * Returns the value of the item.
     * @return T.
     */
    public T getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node<?> node = (Node<?>) o;

        if (value != null ? !value.equals(node.value) : node.value != null) {
            return false;
        }
        if (prev != null ? !prev.equals(node.prev) : node.prev != null) {
            return false;
        }
        return next != null ? next.equals(node.next) : node.next == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (prev != null ? prev.hashCode() : 0);
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
