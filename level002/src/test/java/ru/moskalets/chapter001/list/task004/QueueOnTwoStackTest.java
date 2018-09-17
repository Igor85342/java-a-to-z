package ru.moskalets.chapter001.list.task004;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класса QueutOnTwoStack.
 */
public class QueueOnTwoStackTest {
    /**
     * Добавляет один элемент. При вызове первого и последнего элементов, возвращает этот элемент.
     */
    @Test
    public void whenAddOneElementThenCallFirstAndLast() {
        QueueOnTwoStack<Integer> queueOnTwoStack = new QueueOnTwoStack<>();
        queueOnTwoStack.push(1);
        assertThat(queueOnTwoStack.getFirst().getValue(), is(1));
        assertThat(queueOnTwoStack.getLast().getValue(), is(1));
    }

    /**
     * Добавляет три элемента. При вызове первого, возвращает первый элемент. При вызове
     * последнего, возвращает последний элемент.
     */
    @Test
    public void whenAddThreeElementThenReturnFirstElementAndLastElement() {
        QueueOnTwoStack<Integer> queueOnTwoStack = new QueueOnTwoStack<>();
        queueOnTwoStack.push(1);
        queueOnTwoStack.push(2);
        queueOnTwoStack.push(3);
        assertThat(queueOnTwoStack.getFirst().getValue(), is(1));
        assertThat(queueOnTwoStack.getLast().getValue(), is(3));
    }

    /**
     * Добавляет три элемента, удаляет первый в очереди элемент. При вызове первого возвращает второй элемент.
     */
    @Test
    public void whenDeleteElementReturnFirstElement() {
        QueueOnTwoStack<Integer> queueOnTwoStack = new QueueOnTwoStack<>();
        queueOnTwoStack.push(1);
        queueOnTwoStack.push(2);
        queueOnTwoStack.push(3);
        Node result = queueOnTwoStack.poll();
        assertThat(result.getValue(), is(1));
        assertThat(queueOnTwoStack.getFirst().getValue(), is(2));
        assertThat(queueOnTwoStack.getLast().getValue(), is(3));
    }

    /**
     * Добавляет четыре элемента, удаляет два элемента. При вызове первого возвращает третий.
     * При вызове последнего, возвращает четвертый.
     */
    @Test
    public void whenAddFourElementDeleteTwoElementReturnSecondElement() {
        QueueOnTwoStack<Integer> queueOnTwoStack = new QueueOnTwoStack<>();
        queueOnTwoStack.push(1);
        queueOnTwoStack.push(2);
        queueOnTwoStack.poll();
        queueOnTwoStack.push(3);
        queueOnTwoStack.push(4);
        Node result = queueOnTwoStack.poll();
        assertThat(result.getValue(), is(2));
        assertThat(queueOnTwoStack.getFirst().getValue(), is(3));
        assertThat(queueOnTwoStack.getLast().getValue(), is(4));
    }
}