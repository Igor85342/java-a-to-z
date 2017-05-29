package ru.moskalets.controlQuestions;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * MyFileVisitorTest - Testing the method MyFileVisitor.
 * @author Igor Moskalets
 * @since 29.05.2017
 */
public class MyFileVisitorTest {
    /**
     * This test validates the search for a file in
     * a given directory on a mask and expects to find two files.
     */
    @Test
    public void WhenTheMaskAndPathToDirectoryReturnsListOfFoundFiles() throws IOException {
        String fileMask = "glob:sec?nd*.txt";
        Path pathDirectory = Paths.get("C:\\rootFolder\\");
        String log = "C:\\rootFolder\\log.txt";
        MyFileVisitor mfv = new MyFileVisitor(fileMask,log);
        Files.walkFileTree(pathDirectory, mfv);
        assertThat(mfv.tempPaths.get(0),is("C:\\rootFolder\\firstFolder\\firstFirstFolder\\secendFile.txt"));
        assertThat(mfv.tempPaths.get(1),is("C:\\rootFolder\\firstFolder\\firstFirstFolder\\secondFile.txt"));
    }
}
