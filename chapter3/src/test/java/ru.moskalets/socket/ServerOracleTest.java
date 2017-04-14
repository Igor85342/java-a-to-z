package ru.moskalets.socket;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
/**
 * ServerOracleTest - tests the class ServerOracle.
 * @author Igor Moskalets.
 * @since 14.04.2017.
 */
public class ServerOracleTest {
    @Test
    /**
     * Checks which string method returns.
     * Testing method answerToQuestion().
     */
    public void WhenEnterStringReturnAnotherString() {
        ServerOracle serverOracle = new ServerOracle(7777);
        String inStrFirst = "eXit";
        String inStrSecond = "hellO";
        String inStrTrird = "Name";
        String inStrFourth = "couNtry";
        String inStrFifth = "asdfklesfsf";
        String expectedFirst = "Goodbye.";
        String expectedSecond = "Hello, dear friend.";
        String expectedTrird = "My name is Oracle.";
        String expectedFourth = "I live in Russia.";
        String expectedFifth = "I don't understand.";
        String actualFirst = serverOracle.answerToQuestion(inStrFirst);
        String actualSecond = serverOracle.answerToQuestion(inStrSecond);
        String actualTrird = serverOracle.answerToQuestion(inStrTrird);
        String actualFourth = serverOracle.answerToQuestion(inStrFourth);
        String actualFifth = serverOracle.answerToQuestion(inStrFifth);
        Assert.assertThat(expectedFirst,is(actualFirst));
        Assert.assertThat(expectedSecond,is(actualSecond));
        Assert.assertThat(expectedTrird,is(actualTrird));
        Assert.assertThat(expectedFourth,is(actualFourth));
        Assert.assertThat(expectedFifth,is(actualFifth));
    }
}
