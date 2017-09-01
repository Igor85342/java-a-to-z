package ru.moskalets.list.task2;

/**
 * This class is part of the collection. Contains a value, a link to the previous and next element in the collection.
 * author Igor Moskalets
 * Since 29.08.2017
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
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Node<?> node = (Node<?>) o;

        if (item != null ? !item.equals(node.item) : node.item != null) {
            return false;
        }
        if (next != null ? !next.equals(node.next) : node.next != null) {
            return false;
        }
        return prev != null ? prev.equals(node.prev) : node.prev == null;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        result = 31 * result + (prev != null ? prev.hashCode() : 0);
        return result;
    }
}
