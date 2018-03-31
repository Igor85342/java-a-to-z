package ru.moskalets.chapter2.monitoresynchronizy.task003;

/**
 * This class is part of the collection. Contains a value, a link to the previous and next element in the collection.
 * author Igor Moskalets
 * Since 31.03.2018
 * @param <E> Generic.
 */
public class Node<E> {
    /**
     * Node value.
     */
    private E item;
    /**
     * Next node.
     */
    private Node<E> next;
    /**
     * Prevuous node.
     */
    private Node<E> prev;
    /**
     * Constructor.
     * @param item Node value.
     */
    public Node(E item) {
        this.item = item;
    }
    /**
     * Constructor.
     * @param prev Previous node.
     * @param item Node value.
     */
    public Node(Node<E> prev, E item) {
        this.prev = prev;
        this.item = item;
    }
    /**
     * The method adds a reference to the next element.
     * @param next Next node.
     */
    public void setnext(Node<E> next) {
        this.next = next;
    }
    /**
     * This method returns a value.
     * @return E.
     */
    public E getNode() {
        return this.item;
    }
    /**
     * This method returns a reference to the next element.
     * @return Node.
     */
    public Node getNext() {
        return this.next;
    }
}
