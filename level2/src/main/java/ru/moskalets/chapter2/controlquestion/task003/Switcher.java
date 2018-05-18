package ru.moskalets.chapter2.controlquestion.task003;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * 1) Реализуйте объект, который хранит в себе строку или ее представление. Объекту необходимо:
 *- содержать метод, который принимает на вход значение типа int, конвертирует его в строковое представление
 *(например, 4 -> "4"), а затем добавляет к концу строки.
 *- по требованию возвращать эту строку.
 *2) Реализуйте 2 потока, которые в цикле добавляют всегда одно и то же число (1-й поток число 1,
 *второй поток число 2) в строку из пункта 1.
 *Работа потоков должна быть организована таким образом, чтобы числа добавлялись в строку
 *в следующем порядке: сначала 10 чисел из первого потока, затем 10 чисел из второго, затем снова
 * 10 чисел из первого и так далее.
 */
@ThreadSafe
public class Switcher {
    /**
     * string - строка, в которую добавляются числа.
     */
    @GuardedBy("this")
    private String string = "String: ";
    /**
     * flag - для определения потока.
     */
    private volatile boolean flag = true;
    /**
     * stringLength - длина строки.
     */
    private final int stringLength;

    /**
     * Конструктор.
     * @param stirngLength
     */
    public Switcher(int stirngLength) {
        this.stringLength = stirngLength;
    }
    public static void main(String[] args) {
        Switcher switcher = new Switcher(99);
        switcher.init();
        System.out.println(switcher.getString());
    }

    /**
     * Метод прибавляет число к строке.
     * @param number
     */
    public void concatenation(int number) {
        this.string = this.string.concat(Integer.toString(number));
    }

    /**
     * Запускает два потока, которые прибавляют к строке по очереди по десять чисел.
     */
    public void init() {
        Thread thread001 = new Thread() {
            @Override
            public void run() {
                synchronized (Switcher.this) {
                    while (Switcher.this.string.length() < Switcher.this.stringLength) {
                        while (!Switcher.this.flag) {
                            try {
                                Switcher.this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < 10; i++) {
                            concatenation(1);
                        }
                        Switcher.this.flag = false;
                        Switcher.this.notifyAll();
                    }
                }
            }
        };
        Thread thread002 = new Thread() {
            @Override
            public void run() {
                synchronized (Switcher.this) {
                    while (Switcher.this.string.length() < Switcher.this.stringLength) {
                        while (Switcher.this.flag) {
                            try {
                                Switcher.this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < 10; i++) {
                            concatenation(2);
                        }
                        Switcher.this.flag = true;
                        Switcher.this.notifyAll();
                    }
                }
            }
        };
        thread001.start();
        thread002.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает string.
     * @return
     */
    public String getString() {
        return this.string;
    }
}