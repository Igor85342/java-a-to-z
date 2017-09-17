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
     * index.
     */
    private int index;

    /**
     * Adds a new item to the collection.
     * @param value .
     */
    public void add(T value) {
        if (this.first == null) {
            this.first = new Node(value);
            this.last = this.first;
            this.index = 0;
        } else {
            Node temp = new Node(this.last, value);
            this.last.setNext(temp);
            this.last = temp;
            this.index++;
        }
    }

    /**
     * The method checks if the circuit in the collection.
     * @return boolean.
     */
    public boolean hasCycle() {
        boolean cheak = false;
        Node temp1 = this.first;
        Node temp2 = this.first.getNext();
        if (this.last.getNext() == null) {
            for (int i = 0; i < this.index; i++) {
                if (temp1.getNext().equals(temp2) & temp1.equals(temp2.getPrev())) {
                    temp1 = temp2;
                    temp2 = temp1.getNext();
                } else {
                    cheak = true;
                    break;
                }
            }
        } else {
            cheak = true;
        }
        return cheak;
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
