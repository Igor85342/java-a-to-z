package ru.moskalets.controlQuestions;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import static java.nio.file.FileVisitResult.CONTINUE;

/**
 * MyFileVisitor - raverses a file tree. Searches for files by name or mask.
 * Stores the path and name of the file in the log.
 * @author Igor Moskalets
 * @since 29.05.2017
 */
class MyFileVisitor extends SimpleFileVisitor<Path> {
    private PathMatcher fileMaskMatcher;
    String log;
    ArrayList<String> tempPaths = new ArrayList<>();;
    public MyFileVisitor (String fileMask, String log){
        fileMaskMatcher = FileSystems.getDefault().getPathMatcher(fileMask);
        this.log = log;
    }
    /**
     * Raverses a file tree.
     * @param Path path.
     * @param BasicFileAttributes fileAttributes.
     * @return FileVisitResult.
     */
    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) throws IOException {
        searchFile(path);
        return CONTINUE;
    }
    /**
     * The method writes the names of found files and their paths in the log.
     * @param Path dir.
     * @param IOException exc.
     * @return FileVisitResult.
     */
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        RandomAccessFile logFile = new RandomAccessFile(new File(this.log), "rw");
        try {
            for (String tempPath : tempPaths) {
                logFile.write(tempPath.getBytes());
                logFile.write("\n".getBytes());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            logFile.close();
        }
        return CONTINUE;
    }
    /**
     * The method finds the file and writes it and its path in the collection.
     * @param Path path.
     * @return void.
     */
    public void searchFile(Path path) throws IOException {
        if (fileMaskMatcher.matches(path.getFileName())){
            System.out.format("%s%n",path.getFileName());
            this.tempPaths.add(path.toString());
        }
    }
}
