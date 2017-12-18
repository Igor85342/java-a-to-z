package ru.moskalets.tree.task3;

/**
 * Узел дерева.
 * @param <E>.
 */
public class Node<E> {
    /**
     * Значение узла.
     */
    private E value;
    /**
     * Левый дочерний узел.
     */
    private Node<E> left;
    /**
     * Правый дочерний узел.
     */
    private Node<E> right;

    /**
     * Конструктор.
     * @param value.
     */
    public Node(E value) {
        this.value = value;
    }

    /**
     * Метод вовзращает значение узла.
     * @return.
     */
    public E getValue() {
        return this.value;
    }

    /**
     * Метод возвращает левый дочерний узел.
     * @return.
     */
    public Node<E> getLeft() {
        return this.left;
    }

    /**
     * Метод добавляет левый дочерний узел.
     * @param left.
     */
    public void setLeft(Node<E> left) {
        this.left = left;
    }

    /**
     * Метод возвращает правый дочерний узел.
     * @return.
     */
    public Node<E> getRight() {
        return this.right;
    }

    /**
     * Метод добавляет правый дочерний узел.
     * @param right.
     */
    public void setRight(Node<E> right) {
        this.right = right;
    }
}
