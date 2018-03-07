package ru.moskalets.testtask.task2;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Testing the class ReferenceUnits.
 * @author Igor Moskalets
 * @since 07.03.2018
 */
public class ReferenceUnitsTest {
    /**
     * Выводит отсортированные департаменты.
     */
    @Test
    public void whenSortedAscendTreeSet() {
        ReferenceUnits refU = new ReferenceUnits();
        String[] array = new String[]{"k1\\sk1", "k1\\sk2", "k1\\sk1\\ssk1", "k1\\sk1\\ssk2", "k2", "k2\\sk1\\ssk1", "k2\\sk1\\ssk2"};
        refU.parcing(array);
        refU.print(refU.sortAscending(refU.getDeps()));
        refU.print(refU.sortDescending(refU.getDeps()));

    }
    /**
     * Проверяет метод addingMissingDepartments(). На входе Set состоящий из одного элемента (k1\sk1), возвращает
     * Set  из двух элементов (k1, k1\sk1).
     */
    @Test
    public void testAddingMissingDepartments() {
        ReferenceUnits refU = new ReferenceUnits();
        Set<Dep> input = new HashSet<Dep>(Arrays.asList(new Dep(new ArrayList<>(Arrays.asList("k1", "sk1")))));
        Set<Dep> expected = new HashSet<Dep>(Arrays.asList(new Dep(new ArrayList<>(Arrays.asList("k1", "sk1"))),
                new Dep(new ArrayList<>(Arrays.asList("k1")))));
        refU.addingMissingDepartments(input);
        assertThat(refU.getDeps(), is(expected));
    }
    /**
     * Проверяет метод parcing(). На входе поступает array, вовзращает Set<Dep>.
     */
    @Test
    public void testParcing() {
        ReferenceUnits refU = new ReferenceUnits();
        String[] input = new String[]{"k1", "k1\\sk1", "k2"};
        Set<Dep> expected = new HashSet<Dep>(Arrays.asList(new Dep(new ArrayList<>(Arrays.asList("k1", "sk1"))),
                new Dep(new ArrayList<>(Arrays.asList("k1"))),  new Dep(new ArrayList<>(Arrays.asList("k2")))));
        refU.parcing(input);
        assertThat(refU.getDeps(), is(expected));
    }
}
