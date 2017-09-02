package ru.moskalets.generalizations.task1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the method ConvertList.
 * @author Igor Moskalets
 * @since 08.06.2017
 */
public class ConvertListTest {
    /**
     * When there is an array, return a list with all the elements of this array.
     */
    @Test
    public void whenInputArrayReturnList() {
        ConvertList cl = new ConvertList();
        int[][] inputArray = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(cl.toList(inputArray), is(expected));
    }

    /**
     * When you receive the list, and the number of rows returns an array with the specified number of rows.
     * Missing elements are replaced with zeros.
     */
    @Test
    public void whenInputListReturnArray() {
        ConvertList cl = new ConvertList();
        List<Integer> inputListFirst = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
        int[][] expectedFirst = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        List<Integer> inputListSecond = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int[][] expectedSecond = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {9, 0, 0}};
        List<Integer> inputListThrird = Arrays.asList(0, 1, 2, 3, 4);
        int[][] expectedThrird = {{0, 1, 2}, {3, 4, 0}};
        assertThat(cl.toArray(inputListFirst, 3), is(expectedFirst));
        assertThat(cl.toArray(inputListSecond, 4), is(expectedSecond));
        assertThat(cl.toArray(inputListThrird, 2), is(expectedThrird));
    }

    /**
     * Input receives a list of arrays, returns a list of the elements of these arrays.
     */
    @Test
    public void whenListOfArraysReturnList() {
        ConvertList cl = new ConvertList();
        ArrayList<int[]> list = new ArrayList();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        list.add(new int[]{7, 8, 9, 10});
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(cl.convert(list), is(expected));
    }
}
