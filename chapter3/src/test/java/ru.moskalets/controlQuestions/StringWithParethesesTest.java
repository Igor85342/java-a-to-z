package ru.moskalets.controlQuestions;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * StringWithParethesesTest - tests the class StringWithParetheses.
 * @author Igor Moskalets.
 * @since 16.05.2017.
 */
public class StringWithParethesesTest  {
    /**
     * Method contains the common part of all tests.
     * @param String input.
     * @param String expected.
     * @return void.
     */
    public void testStringWithParetheses (String input, String expected ) throws IOException{
        StringWithParentheses swp = new StringWithParentheses();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        swp.runStringWithParentheses(in,out);
        assertThat(out.toString(), is(expected));
    }
    /**
     * This test validates an incoming string that contains more right parentheses.
     * Testing method runStringWithParentheses().
     */
    @Test
    public void whenMoreRightParenthesesReturnStringWintEqualCountParentheses() throws IOException  {
        this.testStringWithParetheses("((dffd)))","(((dffd)))");
    }
    /**
     * This test validates an incoming string that contains more left parentheses.
     * Testing method runStringWithParentheses().
     */
    @Test
    public void whenMoreLeftParentesesReturnStringWintEaualCountParetheses() throws IOException {
        this.testStringWithParetheses("((df(fd))(","((df(fd))())");
    }
    /**
     * The test checks the incoming row containing the same number of left and right parentheses.
     * Testing method runStringWithParentheses().
     */
    @Test
    public void whenLeftAndRightParentesesEquallyReturnStringWintEaualCountParetheses() throws IOException {
        this.testStringWithParetheses(")dsf()(",")dsf()(");
    }
    /**
     * The test verifies that the incoming string does not have parentheses.
     * Testing method runStringWithParentheses().
     */
    @Test
    public void whenNoParenthesesReturnStringWithoutParetheses() throws IOException {
        this.testStringWithParetheses("dsf","dsf");
    }
}
