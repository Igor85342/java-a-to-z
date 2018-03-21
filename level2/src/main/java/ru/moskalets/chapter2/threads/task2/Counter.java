package ru.moskalets.chapter2.threads.task2;

import java.util.StringTokenizer;

/**
 * Класс считает пробелы и слова в строке. Методы выполняются параллельно.
 */
public class Counter{
    private String string;
    public Counter(String string) {
        this.string = string;
    }
    public static void main(String[] args) {
        Counter counter = new Counter("One two three four five");
        Thread thread01 = new Thread() {
            @Override
            public void run() {
                System.out.println("Start");
            }
        };

        Thread thread02 = new Thread() {
            @Override
            public void run() {
                System.out.println(counter.countingNumberSpaces());
            }
        };

        Thread thread03 = new Thread() {
            @Override
            public void run() {
                System.out.println(counter.countingNamberWords());
            }
        };

        Thread thread04 = new Thread() {
            @Override
            public void run() {
                System.out.println("Finish");
            }
        };
        thread01.start();
        try {
            thread01.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread02.start();
        thread03.start();
       try {
           thread02.join();
           thread03.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread04.start();
    }

    /**
     * Подсчет пробелов в строке.
     * @return
     */
    public int countingNumberSpaces() {
        int count = 0;
        for (int i = 0; i < this.string.length(); i++) {
            if (this.string.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
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
