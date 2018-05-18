package ru.moskalets.chapter2.controlquestion.task003;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
/**
 * Тест для Switcher.
 */
public class SwitcherTest {
    /**
     * Тестирует метод init().
     */
    @Test
    public void initTest() {
        Switcher switcher = new Switcher(99);
        switcher.init();
        String expected = "String: 11111111112222222222111111111122222222221111111111222222222211111111112222222222111111111122222222221111111111";
        assertThat(switcher.getString(), is(expected));
    }
}