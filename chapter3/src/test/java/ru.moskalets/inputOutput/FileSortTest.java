package ru.moskalets.inputOutput;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * FileSortTest - tests the class FileSortTest.
 * @author Igor Moskalets.
 * @since 21.03.2017.
 */
public class FileSortTest {
    /**
     * TMethod reads from a file of strings, sorts them by length, writes to another file.git
     * Testing method sort().
     */
    @Test
    public void WhenNotSortingFileReturnSortingFile() throws IOException {
        File source = new File("C:\\Projects\\java-a-to-z\\chapter3\\src\\main\\java\\ru.moskalets\\inputOutput\\read.txt");
        File distance = new File("C:\\Projects\\java-a-to-z\\chapter3\\src\\main\\java\\ru.moskalets\\inputOutput\\write.txt");
        FileSort fs = new FileSort();
        fs.sort(source, distance);
    }
}
