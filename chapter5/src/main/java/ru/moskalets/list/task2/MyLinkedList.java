package ru.moskalets.list.task2;

import java.util.Iterator;

/**
 * The class is a simple implementation of LindkedList.
 * Each item in this collection has a link to the previous and next element.
 * author Igor Moskalets
 * Since 29.08.2017
 * @param <E>.
 */
public class MyLinkedList<E> implements Iterable<E> {
    /**
     * First Node.
     */
   private Node first;
    /**
     * Last Node.
     */
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
        if (this.first == null) {
            this.first = new Node(value);
            this.last = this.first;
        } else {
            Node temp = new Node(this.last, value);
            this.last.setnext(temp);
            this.last = temp;
        }
    }
    /**
     * This method returns the first element of the collection.
     * @param <E> Node.
     * @return <E> Node
     */
    public <E> Node getFirst() {
        return this.first;
    }
    /**
     * This method returns the last element of the collection.
     * @param <E> Node generic.
     * @return <E> Node.
     */
    public <E> Node getLast() {
        return this.last;
    }
    /**
     * This method returns the element at the specified position.
     * @param pozition Position called a list item.
     * @param <E> Node generic.
     * @return <E> Node.
     */
    public <E> Node get(int pozition) {
       Node temp = first;
       for (int i = 1; i < pozition; i++) {
           temp = temp.getNext();
        }
        return temp;
    }
    /**
     * This method returns an iterator.
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        return this.iterator;
    }
}
