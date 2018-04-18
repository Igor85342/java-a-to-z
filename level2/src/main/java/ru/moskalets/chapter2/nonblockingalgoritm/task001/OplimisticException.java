package ru.moskalets.chapter2.nonblockingalgoritm.task001;

/**
 * Исключение.
 */
public class OplimisticException extends Exception {
    /**
     * Конструктор.
     * @param string
     */
    public OplimisticException(String string) {
        super(string);
    }
}
