package ru.moskalets.controlQuestions;

import java.io.IOException;
import java.nio.file.*;
/**
 * SearchFile - the class searches for files by name
 * or pattern and record the path in the log to a file and the file name.
 * @author Igor Moskalets
 * @since 29.05.2017
 */
public class SearchFile {
    public static void main(String[] args) throws IOException {
        SearchFile sf = new SearchFile();
        sf.help();
        String fileMask = "glob:sec?nd.txt";
        Path pathDirectory = Paths.get("C:\\rootFolder\\");
        String log = "C:\\rootFolder\\log.txt";
        sf.runSearchFile(fileMask, pathDirectory, log);
    }
    /**
     * Launches walking the File Tree.
     * @param String fileMask.
     * @param Path pathDirectory.
     * @param String log.
     * @return void.
     */
    public void runSearchFile(String fileMask, Path pathDirectory, String log) throws IOException{
        Files.walkFileTree(pathDirectory, new MyFileVisitor(fileMask,log));
    }
    /**
     * Displays help.
     * @return void.
     */
    public void help() {
        System.out.format("Введите слово или маску для поиска%n");
        System.out.format("* - заменяет любое количество неизвестных символов%n");
        System.out.format("? - заменяет один неизвестный символ%n");
    }
}

