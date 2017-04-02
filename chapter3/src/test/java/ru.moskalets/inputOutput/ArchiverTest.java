package ru.moskalets.inputOutput;

import org.junit.Test;

/**
 * ArchiverTest - tests the class Archiver.
 * @author Igor Moskalets.
 * @since 02.04.2017.
 */
public class ArchiverTest {
    /**
     * Getting tests files in the archive.
     * Testing method zip().
     */
    @Test
    public void When() throws Exception{
        String pathInput = "C:\\ru.moskalets\\inputOutput";
        String pathOutput = "C:\\ru.moskalets\\inputOutput.zip";
        String filterFormat = "txt";
        Archiver arch = new Archiver(pathInput,pathOutput,filterFormat);
        arch.zip();
    }
}
