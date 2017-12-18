package ru.moskalets.tree.task3;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Данный класс тестирует клаа BinaryTree.
 */
public class BinaryTreeTest {
    /**
     * Тест проверяет метод add(). Добавляетя пять элементов, возвращается количество элементов равное пяти.
     * Возвращется второй добавленный элемент, являющийся левым дочерний узлом корня. Возвращается третрий добавленный
     * элемент, являющийся правым дочерним узлом корня. Возвращется четвертый элемент добавленный в правый дочерний
     * элемент правого дочернего элемента корня. Возвращается пятый элемент добавленный в левый дочерний элемент левого
     * дочернего элемента корня.
     */
    @Test
    public void testAdd() {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.add(10);
        bt.add(5);
        bt.add(15);
        bt.add(20);
        bt.add(3);
        assertThat(bt.getSize(), is(5));
        assertThat(bt.getRoot().getLeft().getValue(), is(5));
        assertThat(bt.getRoot().getRight().getValue(), is(15));
        assertThat(bt.getRoot().getRight().getRight().getValue(), is(20));
        assertThat(bt.getRoot().getLeft().getLeft().getValue(), is(3));
    }
}