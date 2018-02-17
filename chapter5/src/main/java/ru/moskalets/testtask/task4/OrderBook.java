package ru.moskalets.testtask.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 * Основной класс. Реализует парсинг файла на заявки.
 */
public class OrderBook {
    /**
     * books - хранилище ценных бумаг.
     */
    private Map<String, Book> books = new HashMap<String, Book>();
    /**
     * source - файл.
     */
    private String source;

    /**
     * Конструктор.
     */
    public OrderBook() {
    }

    /**
     * Конструктор.
     * @param source
     */
    public OrderBook(String source) {
        this.source = source;
    }

    /**
     * Считывание файла построчно.
     * @throws IOException
     */
    public void parsingFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.source));
        Order order;
        try {
            String string;
            while ((string = br.readLine()) != null) {
                if (string.startsWith("<AddOrder")) {
                    order = parcingAddOrder(string);
                    if (this.books == null || !this.books.containsKey(order.getBook())) {
                        this.books.put(order.getBook(), new Book(order.getBook()));
                        this.books.get(order.getBook()).setOrder(order);
                    } else {
                        if (this.books.containsKey(order.getBook())) {
                            this.books.get(order.getBook()).setOrder(order);
                        }
                    }
                }
                if (string.startsWith("<DeleteOrder")) {
                    parcingDeleteOrder(string);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            br.close();
        }
    }

    /**
     * Разбивка строки на новую заявку.
     * @param string
     * @return
     */
    public Order parcingAddOrder(String string) {
        int index;
        String book = "";
        String operation = "";
        String price = "";
        String volume = "";
        String orderId = "";
        if (string.contains("AddOrder")) {
            for (int i = string.indexOf("book") + 6; i < string.length(); i++) {
                if (string.charAt(i) == '\"') {
                    break;
                }
                book = book + string.charAt(i);
            }
            for (int i = string.indexOf("operation") + 11; i < string.length(); i++) {
                if (string.charAt(i) == '\"') {
                    break;
                }
                operation = operation + string.charAt(i);
            }
            for (int i = string.indexOf("price") + 7; i < string.length(); i++) {
                if (string.charAt(i) == '\"') {
                    price.trim();
                    break;
                }
                price = price + string.charAt(i);
            }
            for (int i = string.indexOf("volume") + 8; i < string.length(); i++) {
                if (string.charAt(i) == '\"') {
                    break;
                }
                volume = volume + string.charAt(i);
            }
            for (int i = string.indexOf("orderId") + 9; i < string.length(); i++) {
                if (string.charAt(i) == '\"') {
                    break;
                }
                orderId = orderId + string.charAt(i);
            }

        }
        return new Order(book, operation, parseDouble(price),  parseInt(volume),  parseInt(orderId));
    }

    /**
     * Разбивка строки на удаление заявки.
     * @param string
     */
    public void parcingDeleteOrder(String string) {
        String book = "";
        String orderId = "";
        for (int i = string.indexOf("book") + 6; i < string.length(); i++) {
            if (string.charAt(i) == '\"') {
                break;
            }
            book = book + string.charAt(i);
        }
        for (int i = string.indexOf("orderId") + 9; i < string.length(); i++) {
            if (string.charAt(i) == '\"') {
                break;
            }
            orderId = orderId + string.charAt(i);
        }
        deleteOrder(book, orderId);
    }

    /**
     * Удаление заявки из книги.
     * @param book
     * @param orderId
     */
    public void deleteOrder(String book, String orderId) {
        this.books.get(book).deleteOrder(parseInt(orderId));
    }

    /**
     * Печать всех книг.
     */
    public void printAllBooks() {
        for (Map.Entry<String, Book> book: this.books.entrySet()) {
            book.getValue().printBook();
            System.out.println("____________________________");
        }
    }
}
