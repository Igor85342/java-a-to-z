package ru.moskalets.tree.task1;


/**
 * Interfice SimpleTree.
 * @param <E>
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Доблавляет узел в дерево.
     * @param parent
     * @param child
     * @return
     */
    boolean add(E parent, E child);
}
