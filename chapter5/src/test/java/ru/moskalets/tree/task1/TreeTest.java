package ru.moskalets.tree.task1;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    /**
     * Добавляется 4 элемента. Возвращается количество равное 4.
     */
    @Test
    public void whenAddMoreNodesReturnsNumberAdded() {
        Tree<Integer> tr = new Tree();
        tr.add(1, 2);
        tr.add(1, 3);
        tr.add(3, 4);
        assertThat(tr.getSize(), is(4));
    }

    /**
     * Добавляется 5 элементов. Один элемент добавляется в несуществующий родительский узел. Возвращается 4 элемента.
     */
    @Test
    public void whenAddMoreNodesOneOfThemIsMissingReturnsNumberAdded() {
        Tree<Integer> tr = new Tree();
        tr.add(1, 2);
        tr.add(1, 3);
        tr.add(3, 4);
        tr.add(5, 6);
        assertThat(tr.getSize(), is(4));
    }

    /**
     * Добавляется 5 элементов. Один из них дублирует уже существующий. Возращается 4 элемента.
     */
    @Test
    public void whenAddMoreNodesOneOfThemIsRedundantReturnsNumberAddedUniqueNodes() {
        Tree<Integer> tr = new Tree();
        tr.add(1, 2);
        tr.add(1, 3);
        tr.add(3, 4);
        tr.add(1, 2);
        assertThat(tr.getSize(), is(4));
    }
    /*
    В дереве пять элементов. Next() вызывается пять раз. HasNext() возвращает ложь.
     */
    @Test
    public void whenThereIsNoNextElementIteratorReturnsFalse() {
        Tree<Integer> tr = new Tree();
        tr.add(1, 2);
        tr.add(1, 3);
        tr.add(3, 4);
        tr.add(4, 5);
        Iterator<Integer> iter = tr.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.hasNext();
        boolean result = iter.hasNext();
        assertThat(result, is(false));
    }

    /**
     * В деревере пять элементов. Next() вызывается четыре раза. HasNext() возвращает true.
     */
    @Test
    public void whenIsNextElementIteratorReturnsTrue() {
        Tree<Integer> tr = new Tree();
        tr.add(1, 2);
        tr.add(1, 3);
        tr.add(3, 4);
        tr.add(4, 5);
        Iterator<Integer> iter = tr.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.hasNext();
        boolean result = iter.hasNext();
        assertThat(result, is(true));
    }

    /**
     * В дереве пять элементов. Next() вызывается один раз и возвращает первый элемент.
     */
    @Test
    public void whenNextIsCalledOnceReturnsFirstElement() {
        Tree<Integer> tr = new Tree();
        tr.add(1, 2);
        tr.add(1, 3);
        tr.add(3, 4);
        tr.add(4, 5);
        Iterator<Integer> iter = tr.iterator();
        int result = iter.next();
        assertThat(result, is(1));
    }

    /**
     * В дереве пять элементов. Next() вызывается пять раз и возвращает пятый элемент.
     */
    @Test
    public void whenNextIsCalledFiveTimesReturnsFifthElement() {
        Tree<Integer> tr = new Tree();
        tr.add(1, 2);
        tr.add(1, 3);
        tr.add(3, 4);
        tr.add(4, 5);
        Iterator<Integer> iter = tr.iterator();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        int result = iter.next();
        assertThat(result, is(5));
    }
}