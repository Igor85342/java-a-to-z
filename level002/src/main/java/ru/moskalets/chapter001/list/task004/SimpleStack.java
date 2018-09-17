package ru.moskalets.chapter001.list.task004;

/**
 * Класс реализует стек.
 * @param <T>
 */
public class SimpleStack<T> {
    /**
     * first.
     */
    private Node first;
    /**
     * last.
     */
    private Node last;

    /**
     * Добавить элемент в конец стека.
     * @param value
     */
    public void push(T value) {
        if (first == null) {
            setFirst(new Node(value));
            setLast(getFirst());
        } else {
            Node temp = new Node(value, getLast());
            this.last.setNext(temp);
            setLast(temp);
        }
    }

    /**
     * Вернуть последний элемент и удалить его из стека.
     * @return
     */
    public Node<T> poll() {
        Node result = null;
        if (this.last != null) {
            result = this.last;
            Node temp = result.getPrev();
            setLast(temp);
            result.setPrev(null);
        }
        return result;
    }

    /**
     * Вставить ссылку на первый элемент.
     * @param node
     */
    public void setFirst(Node node) {
        this.first = node;
    }

    /**
     * Вставить ссылку на последний элемент.
     * @param node
     */
    public void setLast(Node node) {
        this.last = node;
    }

    /**
     * Вернуть первый элемент.
     * @return
     */
    public Node<T> getFirst() {
        return this.first;
    }

    /**
     * Вернуть последний элемент.
     * @return
     */
    public Node<T> getLast() {
        return this.last;
    }

    /**
     * Обнулить ссылки на первый и последний элементы.
     */
    public void clean() {
        this.first = null;
        this.last = null;
    }
}