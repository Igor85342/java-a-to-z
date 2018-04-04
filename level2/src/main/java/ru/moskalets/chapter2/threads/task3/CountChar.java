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
    public static void main(String[] arg) {
        new Thread(new CountChar("asdfafsafdasdf")).start();
    }
    @Override
    public void run() {
        int length = countNumberOfCharacters();
        System.out.format("The number of characters equals: %d%n", length);
        System.exit(0);
    }

    /**
     * Подсчет количества символов в строке.
     * @return int.
     */
    public int countNumberOfCharacters() {
        Thread timeThread = new Thread(new Time(10000));
        timeThread.start();
        int length = 0;
        for (int i = 0; i < this.line.length(); i++) {
            length++;
            if (timeThread.isInterrupted()) {
                System.exit(0);
            }
        }
        return length;
    }
}
