package ru.moskalets.list.task4;

/**
 * The class is a SimpleLinkedList.
 * author Igor Moskalets
 * Since 08.09.2017
 * @param <T>
 */
public class SimpleLinkedList<T> {
    /**
     * first - the first element in the collection.
     */
    private Node first;
    /**
     * last - the last element in the collection.
     */
    private Node last;

    /**
     * Adds a new item to the collection.
     * @param value .
     */
    public void add(T value) {
        if (this.first == null) {
            this.first = new Node(value);
            this.last = this.first;
        } else {
            Node temp = new Node(this.last, value);
            this.last.setNext(temp);
            this.last = temp;
        }
    }

    /**
     * The method checks if the circuit in the collection.
     * @return boolean.
     */
    public boolean hasCycle() {
        return this.last.getNext() != null;
    }

    /**
     * Get first Element.
     * @param <T> .
     * @return Node.
     */
    public <T> Node getFirst() {
        return this.first;
    }

    /**
     * Get last element.
     * @param <T> .
     * @return Node.
     */
    public <T> Node getLast() {
        return this.last;
    }

    /**
     * Returns the element at position.
     * @param pozition .
     * @param <T> .
     * @return Node.
     */
    public <T> Node get(int pozition) {
        Node temp = first;
        for (int i = 1; i < pozition; i++) {
            temp = temp.getNext();
        }
        return temp;
    }
}
