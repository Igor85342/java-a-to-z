package ru.moskalets.chapter2.waitnotifynotifyall.task004;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Тест для класса ParallelSearch.
 */
public class ParallelSearchTest {
    /**
     * Запускаем поиск текста, находим три файла разных форматов.
     */
    @Test
    public void whenRunParallelSearchThanFindThreeFiles() {
        List<String> exts = new ArrayList<>();
        exts.add(".txt");
        exts.add(".rtf");
        ParallelSearch ps = new ParallelSearch("C:\\rootFolder", "find", exts);
        ps.init();
        assertThat(ps.result().size(), is(3));
    }
}