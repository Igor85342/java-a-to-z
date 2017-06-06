package ru.moskalets.collectionsFramework.task2;

import java.util.*;

/**
 * PerformanceTestingCollections - compares the speed of adding and deleting items in the three collections.
 * @author Igor Moskalets
 * @since 04.06.2017
 */
public class PerformanceTestingCollections {
    ArrayList<String> collectionsArrayList = new ArrayList<>();
    LinkedList<String> collectionsLinkedList = new LinkedList<>();
    TreeSet<String> collectionsTreeSet = new TreeSet<>();
    public static void main(String[] args){
        PerformanceTestingCollections ptc = new PerformanceTestingCollections();
        ptc.runPerformanceTestingCollections();
    }
    /**
     * The main method of the class.
     * @return void.
     */
    public void runPerformanceTestingCollections(){
        int countAdd = 1000000;
        long timeAddArrayList = add(this.collectionsArrayList, countAdd);
        long timeAddLinkedList = add(this.collectionsLinkedList, countAdd);
        long timeAddTreeSet = add(this.collectionsTreeSet, countAdd);
        System.out.format("ArrayList add - %s%n",timeAddArrayList);
        System.out.format("LinkedList add - %s%n",timeAddLinkedList);
        System.out.format("TreeSet add - %s%n",timeAddTreeSet);
        int countDelete = 10000;
        long timeDeleteArrayList = delete(this.collectionsArrayList,countDelete );
        long timeDeleteLinkedList = delete(this.collectionsLinkedList,countDelete );
        long timeDeleteTreeSet = delete(this.collectionsTreeSet,countDelete );
        System.out.format("ArrayList delete - %s%n",timeDeleteArrayList);
        System.out.format("LinkedList delete - %s%n",timeDeleteLinkedList);
        System.out.format("TreeSet delete - %s%n",timeDeleteTreeSet);
    }
    /**
     * Adds elements to the collection.
     * @param Collection<String> collection.
     * @param int amount.
     * @return void.
     */
    private long add(Collection<String> collection, int amount) {
        Date start = new Date();
        for (int i=0; i < amount; i++) {
            collection.add(Integer.toString(i));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }
    /**
     * Removes elements from the collection.
     * @param Collection<String> collection.
     * @param int amount.
     * @return void.
     */
    private long delete(Collection<String> collection, int amount){
        Date start = new Date();
        Iterator iterator = collection.iterator();
        for (int i = 0; i < amount; i++){
            while(iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }

}
