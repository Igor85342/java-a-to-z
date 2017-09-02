package ru.moskalets.collectionsframework.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Date;
import java.util.Iterator;

/**
 * PerformanceTestingCollections - compares the speed of adding and deleting items in the three collections.
 * @author Igor Moskalets
 * @since 04.06.2017
 */
public class PerformanceTestingCollections {
    /**
     * collectionsArrayList.
     */
    private ArrayList<String> collectionsArrayList = new ArrayList<>();
    /**
     * collectionsLinkedList.
     */
    private LinkedList<String> collectionsLinkedList = new LinkedList<>();
    /**
     * collectionsTreeSet.
     */
    private TreeSet<String> collectionsTreeSet = new TreeSet<>();


    /**
     * main.
     * @param args .
     */
    public static void main(String[] args) {
        PerformanceTestingCollections ptc = new PerformanceTestingCollections();
        ptc.runPerformanceTestingCollections();
    }

    /**
     * Get collectionsArrayList.
     * @return ArrayList.
     */
    public ArrayList getArrayList() {
        return this.collectionsArrayList;
    }

    /**
     * Get collectionsLinkedList.
     * @return LinkedList.
     */
    public LinkedList getLinkedList() {
        return this.collectionsLinkedList;
    }

    /**
     * Get collectionsTreeSet.
     * @return TreeSet.
     */
    public TreeSet getTreeSet() {
        return this.collectionsTreeSet;
    }
    /**
     * The main method of the class.
     */
    public void runPerformanceTestingCollections() {
        int countAdd = 1000000;
        long timeAddArrayList = add(this.collectionsArrayList, countAdd);
        long timeAddLinkedList = add(this.collectionsLinkedList, countAdd);
        long timeAddTreeSet = add(this.collectionsTreeSet, countAdd);
        System.out.format("ArrayList add - %s%n", timeAddArrayList);
        System.out.format("LinkedList add - %s%n", timeAddLinkedList);
        System.out.format("TreeSet add - %s%n", timeAddTreeSet);
        int countDelete = 10000;
        long timeDeleteArrayList = delete(this.collectionsArrayList, countDelete);
        long timeDeleteLinkedList = delete(this.collectionsLinkedList, countDelete);
        long timeDeleteTreeSet = delete(this.collectionsTreeSet, countDelete);
        System.out.format("ArrayList delete - %s%n", timeDeleteArrayList);
        System.out.format("LinkedList delete - %s%n", timeDeleteLinkedList);
        System.out.format("TreeSet delete - %s%n", timeDeleteTreeSet);
    }
    /**
     * Adds elements to the collection.
     * @param collection .
     * @param amount .
     * @return long.
     */
    private long add(Collection<String> collection, int amount) {
        Date start = new Date();
        for (int i = 0; i < amount; i++) {
            collection.add(Integer.toString(i));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }
    /**
     * Removes elements from the collection.
     * @param collection .
     * @param amount .
     * @return long.
     */
    private long delete(Collection<String> collection, int amount) {
        Date start = new Date();
        Iterator iterator = collection.iterator();
        for (int i = 0; i < amount; i++) {
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }

}
