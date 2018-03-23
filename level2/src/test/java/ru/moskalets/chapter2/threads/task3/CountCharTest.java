package ru.moskalets.chapter2.threads.task3;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Тест класса CountChar.
 */
public class CountCharTest {
    /**
     * Проверяет метод countNumberOfCharacters();
     */
    @Test
    public void countNumberOfCharactersTest() {
        CountChar cc = new CountChar("123456789");
        assertThat(cc.countNumberOfCharacters(), is(9));
    }

}