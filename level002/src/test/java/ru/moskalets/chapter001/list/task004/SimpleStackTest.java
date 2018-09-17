package ru.moskalets.chapter001.list.task004;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для класс SimpleStack
 */
public class SimpleStackTest {
    /**
     * Добавляет один элемент. При вызове первого и послденего элемента в стеки возвращает
     * этот элемент.
     */
    @Test
    public void whenAddOneElementThenReturnFirstElementandLastElement() {
        SimpleStack<Integer> simplestack = new SimpleStack<>();
        simplestack.push(1);
        assertThat(simplestack.getFirst().getValue(), is(1));
        assertThat(simplestack.getLast().getValue(), is(1));
    }

    /**
     * Добавляет три элемента. При вызове первого, возвращает первый элемент.
     * При вызове последнего, возвращает третий элемент.
     */
    @Test
    public void whenAddThreeElementThenReturnFirstElementAndLastElement() {
        SimpleStack<Integer> simplestack = new SimpleStack<>();
        simplestack.push(1);
        simplestack.push(2);
        simplestack.push(3);
        assertThat(simplestack.getFirst().getValue(), is(1));
        assertThat(simplestack.getLast().getValue(), is(3));
    }

    /**
     * Добавляет три элемента, удаляет первый. При вызове последнего, возвращает второй добавленный элемент.
     */
    @Test
    public void whenDeleteThridElementThenCallLastElementReturnSecondElement() {
        SimpleStack<Integer> simplestack = new SimpleStack<>();
        simplestack.push(1);
        simplestack.push(2);
        simplestack.push(3);
        Node node = simplestack.poll();
        assertThat(simplestack.getLast().getValue(), is(2));
        assertThat(node.getValue(), is(3));
    }
}