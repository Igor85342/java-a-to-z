package ru.moskalets.list.task3;

/**
 * The class is a simple implementation of Queue.
 * author Igor Moskalets
 * Since 04.09.2017
 * @param <T> .
 */
public class SimpleQueue<T> extends BaseLinkedList {
    /**
     * The method removes the first element and returns its value.
     * @param <T> .
     * @return Node.
     */
    public <T> Node poll() {
        Node temp = getFirst();
        setFirst(temp.getNext());
        return temp;
    }
}
