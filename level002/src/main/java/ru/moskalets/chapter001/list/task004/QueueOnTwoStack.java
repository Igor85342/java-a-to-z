package ru.moskalets.chapter001.list.task004;

/**
 * Класс реализует очередь на двух стеках.
 * @param <T>
 */
public class QueueOnTwoStack<T> {
    /**
     * firstStack.
     */
    private SimpleStack<T> firstStack = new SimpleStack<T>();
    /**
     * secondStack.
     */
    private SimpleStack<T> secondStack = new SimpleStack<T>();

    /**
     * Добавить элемент в конец очереди.
     * @param value
     */
    public void push(T value) {
            firstStack.push(value);
    }

    /**
     * Вернуть первый элемент и удалить его из очереди.
     * @return
     */
    public Node<T> poll() {
        Node<T> result;
        Node node = firstStack.poll();
        while (node != null) {
            secondStack.push((T) node.getValue());
            node = firstStack.poll();
        }
        result = secondStack.poll();
        firstStack.clean();
        node = secondStack.poll();
        while (node != null) {
            firstStack.push((T) node.getValue());
            node = secondStack.poll();
        }
        secondStack.clean();
        return result;
    }

    /**
     * Вернуть первый элемент в очереди.
     * @return
     */
    public Node<T> getFirst() {
        return this.firstStack.getFirst();
    }

    /**
     * Вернуть последний элемент в очереди.
     * @return
     */
    public Node<T> getLast() {
        return this.firstStack.getLast();
    }
}