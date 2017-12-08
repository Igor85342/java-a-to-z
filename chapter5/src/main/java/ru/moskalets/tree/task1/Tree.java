package ru.moskalets.tree.task1;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Tree - класс реализует простое дерево. Узел дерева может иметь сколько угодно дочерних элементов.
 * Элементы дерева уникальные.
 * @param <E>
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Root - корневой узел.
     */
    private Node<E> root;
    /**
     * Size - Количество элементов в дереве.
     */
    private int size = 0;

    /**
     * Добавляет уникальный узел в дерево. При добавление указывается значение родительского узла и значение
     * узла который необходимо добавлить. Значение дочернего элемента добавляется, только елси оно уникальное.
     * @param parent
     * @param child
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (this.root == null) {
            this.root = new Node(parent, child);
                result = true;
                size = size + 2;
        } else {
            if (find(this.root, child) == null) {
                if (find(this.root, parent) != null) {
                    find(this.root, parent).setChildren(child);
                    result = true;
                    size++;
                }
            }
        }
        return result;
    }

    /**
     * Поиск узла по значению.
     * @param tempRoot
     * @param value
     * @return
     */
    public Node<E> find(Node<E> tempRoot, E value) {
    Node<E> result = null;
    if (tempRoot.getValue().compareTo(value) == 0) {
        result = tempRoot;
    }
    if (result == null) {
        if (tempRoot.getChildren() != null) {
            for (Node<E> child: tempRoot.getChildren()) {
                if (child.getValue().compareTo(value) == 0) {
                    result = child;
                    break;
                } else {
                    if (child.getChildren() != null && find(child, value) != null) {
                        result = find(child, value);
                        break;
                    }
                }
            }
        }
    }
    return result;
    }
    public int getSize() {
        return this.size;
    }

    /**
     * Итератор. Собирает все элеметы из дерева в list, и возвращает данные из него.
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }
    private class TreeIterator implements Iterator {
        /**
         * List - хранит все элементы из дерева. Обход в глубину.
         */
        private ArrayList<E> arrayList;
        /**
         * Index - индекс интератора.
         */
        private int index;

        /**
         * Конструктор. При создании, элементы из дерева копируются в list.
         */
        public TreeIterator() {
            this.arrayList = new ArrayList<E>();
            copy(Tree.this.root);
        }

        /**
         * Проверяет есть ли следующий элемент.
         * @return
         */
        @Override
        public boolean hasNext() {
            boolean cheak = false;
            if (this.index < this.arrayList.size()) {
                cheak = true;
            }
            return cheak;
        }

        /**
         * Возвращает следующий элемент.
         * @return
         */
        @Override
        public Object next() {
            E result = null;
            if (hasNext()) {
                result =  this.arrayList.get(this.index++);
            }
            return result;
        }

        /**
         * Копирует элементы из tree в list.
         * @param tempRoot
         * @return
         */
        public boolean copy(Node<E> tempRoot) {
            boolean flag = false;
            if (tempRoot != null) {
                this.arrayList.add(tempRoot.getValue());
                flag = true;
            }
            if (tempRoot.getChildren() != null) {
                for (Node<E> child: tempRoot.getChildren()) {
                    copy(child);
                }
            }
            return flag;
        }
    }

}
