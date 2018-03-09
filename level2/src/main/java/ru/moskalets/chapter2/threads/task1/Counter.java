package ru.moskalets.chapter2.threads.task1;

import java.util.StringTokenizer;

/**
 * Класс считает пробелы и слова в строке. Методы выполняются параллельно.
 */
public class Counter {
    private String string;
    public Counter(String string) {
        this.string = string;
    }
    public static void main(String[] args) {
        Counter counter = new Counter("One two three four five");
        new Thread() {
            @Override
            public void run() {
                System.out.println(counter.countingNumberSpaces());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println(counter.countingNamberWords());
            }
        }.start();
    }

    /**
     * Подсчет пробелов в строке.
     * @return
     */
    public int countingNumberSpaces() {
            return this.string.length() - this.string.replace(" ", "").length();
    }

    /**
     * Подсчет слов в строке.
     * @return
     */
    public int countingNamberWords() {
        StringTokenizer st = new StringTokenizer(this.string);
        return st.countTokens();
    }
}
