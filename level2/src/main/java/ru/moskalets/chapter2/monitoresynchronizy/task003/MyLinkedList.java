package ru.moskalets.chapter2.monitoresynchronizy.task003;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;

/**
 * The class is a simple implementation of LindkedList.
 * Each item in this collection has a link to the previous and next element.
 * author Igor Moskalets
 * Since 31.03.2018
 * @param <E>.
 */
@ThreadSafe
public class MyLinkedList<E> implements Iterable<E> {
    /**
     * First Node.
     */
    @GuardedBy("this")
   private Node first;
    /**
     * Last Node.
     */
    @GuardedBy("this")
   private Node last;
    /**
     * iterator.
     */
   private Iterator<E> iterator;
    /**
     * The method adds a new item to the collection.
     * @param value Node value.
     */
    public void add(E value) {
        synchronized (this) {
            if (this.first == null) {
                this.first = new Node(value);
                this.last = this.first;
            } else {
                Node temp = new Node(this.last, value);
                this.last.setnext(temp);
                this.last = temp;
            }
        }
    }
    /**
     * This method returns the first element of the collection.
     * @param <E> Node.
     * @return <E> Node
     */
    public <E> Node getFirst() {
        synchronized (this) {
            return this.first;
        }
    }
    /**
     * This method returns the last element of the collection.
     * @param <E> Node generic.
     * @return <E> Node.
     */
    public <E> Node getLast() {
        synchronized (this) {
            return this.last;
        }
    }
    /**
     * This method returns the element at the specified position.
     * @param pozition Position called a list item.
     * @param <E> Node generic.
     * @return <E> Node.
     */
    public <E> Node get(int pozition) {
        synchronized (this) {
            Node temp = first;
            for (int i = 1; i < pozition; i++) {
                temp = temp.getNext();
            }
            return temp;
        }
    }
    /**
     * This method returns an iterator.
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        return new LinkedListIterator<E>();
    }
    private class LinkedListIterator<E> implements Iterator<E> {
        /**
         * Current node.
         */
        private Node currentNode;

        /**
         * Constructor.
         */
        LinkedListIterator() {
            this.currentNode = MyLinkedList.this.first;
        }

        @Override
        public boolean hasNext() {
                return this.currentNode != getFirst();
        }

        @Override
        public E next() {
            Node result = this.currentNode;
            if (hasNext()) {
                this.currentNode = this.currentNode.getNext();
            }
            return (E) result;
        }
    }
}
