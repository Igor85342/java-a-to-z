package ru.moskalets.tree.task1;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс - узел.
 * @param <E>
 */
public class Node<E> {
    /**
     * Children - список дочерних узлов.
     */
    private List<Node<E>> children;
    /**
     * Value - значение.
     */
    private E value;

    /**
     * Конструктор со значением.
     * @param value
     */
    public Node(E value) {
        this.value = value;
    }

    /**
     * Конструктор со значением и с дочерними узлами.
     * @param value
     * @param child
     */
    public Node(E value, E child) {
        this.value = value;
        this.children = new ArrayList<Node<E>>();
        this.children.add(new Node(child));

    }

    /**
     * Возвращает список дочерних узлов.
     * @return
     */
    public List<Node<E>> getChildren() {
        return this.children;
    }

    /**
     * Возвращает значение.
     * @return
     */
    public E getValue() {
        return this.value;
    }

    /**
     * Добавляет дочерний узел по значению.
     * @param child
     */
    public void setChildren(E child) {
        if (this.children == null) {
            this.children = new ArrayList<Node<E>>();
        }
        this.children.add(new Node(child));
    }
}
