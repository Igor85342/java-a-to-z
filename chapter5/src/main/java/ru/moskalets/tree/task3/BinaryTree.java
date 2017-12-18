package ru.moskalets.tree.task3;

/**
 * Класс реализует двоиченое дерево поиска(binary search tree). Корень имеет два дочерних элемента: left и right.
 * Каждый из этих узлов в свою очередь, может быть корнем для своих левых и правых поддеревьев.
 * Элемент слева от корня, меньше либо равен корню, а правый больше корня.
 * @param <E>.
 */
public class BinaryTree<E extends Comparable<E>> {
    /**
     * Корневой узел.
     */
    private Node<E> root;
    /**
     * Количество элементов в дереве.
     */
    private int size;

    /**
     * Добавляет узел в дерево.
     * @param value.
     * @return.
     */
    public boolean add(E value) {
        boolean result = false;
        if (this.root == null) {
            this.root = new Node<E>(value);
            result = true;
            this.size++;
        } else {
            addingNodeToBranch(this.root, value);
        }
        return result;
    }

    /**
     * Добавляет узел в правую и левую ветвь узла.
     * @param tempRoot.
     * @param value.
     * @return.
     */
    public boolean addingNodeToBranch(Node<E> tempRoot, E value) {
        boolean result = false;
        if (tempRoot.getValue().compareTo(value) >= 0) {
            if (tempRoot.getLeft() == null) {
                tempRoot.setLeft(new Node<E>(value));
                result = true;
                this.size++;
            } else {
                addingNodeToBranch(tempRoot.getLeft(), value);
            }
        } else {
            if (tempRoot.getRight() == null) {
                tempRoot.setRight(new Node<E>(value));
                result = true;
                this.size++;
            } else {
                addingNodeToBranch(tempRoot.getRight(), value);
            }
        }
        return result;
    }

    /**
     * Возвращет количество элементов дерева.
     * @return.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Возвращает корень дерева.
     * @return.
     */
    public Node<E> getRoot() {
        return this.root;
    }
}
