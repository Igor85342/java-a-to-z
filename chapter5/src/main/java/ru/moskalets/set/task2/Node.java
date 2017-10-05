package ru.moskalets.set.task2;

/**
 * The class implements the node. Contains links to previous and next nodes.
 * @param <E>
 */
public class Node<E> {
    /**
     * The value of the node.
     */
    private E e;
    /**
     * The following element.
     */
    private Node<E> next;
    /**
     * Previous item.
     */
    private Node<E> prev;
    /**
     * Constructor.
     * @param e .
     */
    public Node(E e) {
       this.e = e;
    }
    /**
     * Constructor.
     * @param prev .
     * @param e .
     */
    public Node(Node prev, E e) {
        this.prev = prev;
        this.e = e;
    }
    /**
     * Returns the element that comes after this.
     * @return E.
     */
    public Node<E> getNext() {
        return this.next;
    }
    /**
     * Adds a reference to the next node in this node.
     * @param next .
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Returns the value of the node.
     * @return E.
     */
    public E getE() {
        return this.e;
    }

    /**
     * Checks whether the next element.
     * @return boolean.
     */
    public boolean hasNext() {
        boolean flag = false;
        if (this.next != null) {
            flag = true;
        }
        return flag;
    }
}
