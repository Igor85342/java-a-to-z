package ru.moskalets.list.task3;

/**
 * The class is a base LinkedList.
 * author Igor Moskalets
 * Since 04.09.2017
 * @param <T> .
 */
public class BaseLinkedList<T> {
    /**
     * The first element of the collection.
     */
    private Node first;
    /**
     * The last element of the collection.
     */
    private Node last;

    /**
     * The method adds an element to the collection.
     * @param value .
     */
    public void push(T value) {
        if (getFirst() == null) {
            setFirst(new Node(value));
            setLast(getFirst());
        } else {
            Node temp = new Node(getLast(), value);
            Node tempLast = getLast();
            tempLast.setnext(temp);
            setLast(temp);
        }
    }

    /**
     * The method set the first item.
     * @param first .
     */
    public void setFirst(Node first) {
        this.first = first;
    }

    /**
     * The method returns the first element.
     * @return Node.
     */
    public Node getFirst() {
        return this.first;
    }

    /**
     * The method set the last item.
     * @param last .
     */
    public void setLast(Node last) {
        this.last = last;
    }

    /**
     * The method returns the last element.
     * @return Node.
     */
    public Node getLast() {
        return this.last;
    }
}
