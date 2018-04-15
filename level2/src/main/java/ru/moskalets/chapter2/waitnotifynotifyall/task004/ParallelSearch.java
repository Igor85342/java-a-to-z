package ru.moskalets.chapter2.waitnotifynotifyall.task004;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Класс ищет заданный текст в файловой системе.
 */
@ThreadSafe
public class ParallelSearch {
    /**
     * root - путь до папки, откуда надо осуществлять поиск.
     */
    private final String root;
    /*
    text - заданный текст.
     */
    private final String text;
    /*
    exts - расширения файлов в которых надо делать поиск.
     */
    private final List<String> exts;
    /*
    visitor - обходчик файлов.
     */
    private final Visitor visitor = new Visitor();
    /*
    finish - окончания обхода дерева файлов.
     */
    volatile boolean finish = false;
    /*
    files - список файлов в которых будет происходить поиск файлов.
     */
    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();
    /*
    paths - список файлол, в которых был найден заданный текст.
     */
    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();

    /*
    Конструктор.
     */
    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }
    /*
    Запуск visitor и обход дерева файлов.
     */
    public void startVisitor() throws IOException {
        Path path = Paths.get(this.root);
        Files.walkFileTree(path, this.visitor);
        this.finish = true;
    }
    /*
    Метод добавляет файл в список файлов для поиска текстов.
     */
    public void addFiles(String line) {
        synchronized (this) {
            this.files.add(line);
            notify();
        }
    }
    /*
    Метод добавляет файл в список файлов, где текст был найден. Если в files нет файлов и обход
    всего дерева еще не закончен, ожидает добавления файла  в files или окончания обхода дерева.
     */
    public void addPaths() throws Exception {
        synchronized (this) {
            while (!files.isEmpty() | !finish) {
                while (files.isEmpty()) {
                    wait();
                }
                String file = files.poll();
                if (findText(file)) {
                    this.paths.add(file);
                }
            }
        }
    }
    /*
    Метод ищет текст в файле.
     */
    public boolean findText(String file) throws Exception {
        boolean flag = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(this.text)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    /*
    Метод запускает два потока. Поток read ищет текст в файлах нужного разрещения. Поток search добавляет
    файлы с нужным разрещением в список.
     */
    public void init() {
        Thread read = new Thread() {
            @Override
            public void run() {
                try {
                    addPaths();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread search = new Thread() {
            @Override
            public void run() {
                try {
                    startVisitor();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        search.start();
        read.start();
        try {
            search.join();
            read.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        print();
    }
    /*
    Возвращает список файлов где был найден заданный текст.
     */
    public synchronized List<String> result() {
        return this.paths;
    }
    /*
    Печатает список файлов где был найден заданный текст.
     */
    public void print() {
        synchronized (this) {
            for (String line : this.paths) {
                System.out.println(line);
            }
        }
    }
    /*
    Класс реализует объект, для обхода дерева файлов и добавления файлов с нужным разрешением в список.
     */
    public class Visitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            for (String ext: ParallelSearch.this.exts) {
                if (path.toString().endsWith(ext)) {
                    ParallelSearch.this.addFiles(path.toString());
                }
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
