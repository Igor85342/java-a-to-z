package ru.moskalets.inputOutput;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * ConsoleChatTest - tests the class ConsoleChat.
 * @author Igor Moskalets.
 * @since 07.04.2017.
 */
public class ConsoleChatTest extends Assert {
    /**
     * Check that the string is not null.
     * Testing method getPhrase().
     */
    @Test
    public void WhenGetPhraseReturnNotNull() throws IOException {
        String source = "C:\\Projects\\java-a-to-z\\chapter3\\src\\main\\java\\ru.moskalets\\inputOutput\\phrasesForChat.txt";
        String distance = "C:\\Projects\\java-a-to-z\\chapter3\\src\\main\\java\\ru.moskalets\\inputOutput\\log.txt";
        ConsoleChat cc = new ConsoleChat(source,distance);
        String actual = cc.getPhrase();
        String notExpected = null;
        assertNotEquals(actual,notExpected);
    }

}
