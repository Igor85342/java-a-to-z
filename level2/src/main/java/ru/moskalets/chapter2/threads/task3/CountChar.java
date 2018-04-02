package ru.moskalets.chapter2.threads.task3;

/**
 * Класс CountChar считает сколько символов в строке.
 */
public class CountChar implements Runnable {
    /**
     * line.
     */
    private String line;

    /**
     * Констурктор.
     * @param line
     */
    public CountChar(String line) {
        this.line = line;
    }
    @Override
    public void run() {
        int length = countNumberOfCharacters();
        System.out.format("The number of characters equals: %d%n", length);
        Thread.currentThread().interrupt();
    }

    /**
     * Подсчет количества символов в строке.
     * @return int.
     */
    public int countNumberOfCharacters() {
        return this.line.length();
    }
}
