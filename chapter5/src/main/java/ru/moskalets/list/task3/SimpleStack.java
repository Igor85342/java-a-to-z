package ru.moskalets.list.task3;

/**
 * The class is a simple implementation of Stack.
 * author Igor Moskalets
 * Since 04.09.2017
 * @param <T>
 */
public class SimpleStack<T> extends BaseLinkedList {
    /**
     * The method removes the last element and returns its value.
     * @param <T> .
     * @return Node.
     */
    public <T> Node poll() {
        Node temp = getLast();
        setLast(temp.getPrev());
        return temp;
    }





}
