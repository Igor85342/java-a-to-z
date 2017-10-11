package ru.moskalets.set.task2;
import java.util.Iterator;
/**
 * The class implements a simple collection based on linked lists.
 * @param <E> .
 */

public class LinkedSimpleSet<E> implements Iterable {
    /**
     * First node.
     */
    private Node<E> first;
    /**
     * Last node.
     */
    private Node<E> last;

    /**
     * Adds a new node.
     * @param e .
     */
    public void add(E e) {
        if (this.first == null) {
            this.first = new Node(e);
            this.last = this.first;
        } else {
            Node temp = new Node(this.last, e);
            if (contains(temp)) {
                this.last.setNext(temp);
                this.last = temp;
            }
        }
    }

    /**
     * The method checks the uniqueness of the item.
     * @param temp .
     * @return boolean.
     */
    public boolean contains(Node temp) {
        Node nodeForCycle = this.first;
        boolean flagOfUniqueness = true;
           while (nodeForCycle != null) {
                if (temp.getE().equals(nodeForCycle.getE())) {
                    flagOfUniqueness = false;
                    break;
                }
                nodeForCycle = nodeForCycle.getNext();
            }
        return flagOfUniqueness;
    }
    /**
     * Return first node.
     * @return Node.
     */
    public Node getFirst() {
        return this.first;
    }

    /**
     * Return last node.
     * @return Node.
     */
    public Node getLast() {
        return this.last;
    }

    /**
     * Return size.
     * @return int.
     */
    public int getSize() {
        int size = 1;
        Node temp = this.first;
        if (this.first.equals(this.last)) {
            size = 1;
        } else {
            while (!temp.equals(this.last)) {
                size++;
                temp = temp.getNext();
            }
        }
        return size;
    }
    @Override
    public Iterator iterator() {
        return new LinkedSimpleSetIterator<E>();
    }

    /**
     * Iterator.
     * @param <E> .
     */
    private class LinkedSimpleSetIterator<E> implements Iterator<E> {
        /**
         * indexIterator.
         */
        private int indexIterator = 0;
        /**
         * Current node.
         */
        private Node currentNode;

        /**
         * Constructor.
         */
        LinkedSimpleSetIterator() {
            this.currentNode = LinkedSimpleSet.this.first;
        }
        @Override
        public boolean hasNext() {
            return this.indexIterator < getSize();
        }

        @Override
        public E next() {
            Node result = this.currentNode;
            if (hasNext()) {
                this.currentNode = this.currentNode.getNext();
                this.indexIterator++;
            }
            return (E) result.getE();
        }
    }
}
