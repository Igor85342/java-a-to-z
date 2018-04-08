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
    }

    /**
     * Подсчет количества символов в строке.
     * @return int.
     */
    public int countNumberOfCharacters() {
        int length = 0;
        for (int i = 0; i < this.line.length(); i++) {
            length++;
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
        }
        return length;
    }
}
