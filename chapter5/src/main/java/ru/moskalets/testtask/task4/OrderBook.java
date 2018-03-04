package ru.moskalets.testtask.task4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
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
     * Парсин файла.
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public void parsingFile() throws ParserConfigurationException, IOException, SAXException {
        DefaultHandler handler = new DefaultHandler() {

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equals("AddOrder")) {
                    Order order = new Order(
                            attributes.getValue("book"),
                            attributes.getValue("operation"),
                            parseDouble(attributes.getValue("price")),
                            parseInt(attributes.getValue("volume")),
                            parseInt(attributes.getValue("orderId"))
                    );
                    if (OrderBook.this.books == null || !OrderBook.this.books.containsKey(order.getBook())) {
                        OrderBook.this.books.put(order.getBook(), new Book(order.getBook()));
                        OrderBook.this.books.get(order.getBook()).setOrder(order);
                    } else {
                        if (OrderBook.this.books.containsKey(order.getBook())) {
                            OrderBook.this.books.get(order.getBook()).setOrder(order);
                        }
                    }
                }
                if (qName.equals("DeleteOrder")) {
                   String book = attributes.getValue("book");
                   int orderId = parseInt(attributes.getValue("orderId"));
                    deleteOrder(book, orderId);
                }
            }
        };
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File(this.source), handler);

    }

    /**
     * Удаление заявки из книги.
     * @param book
     * @param orderId
     */
    public void deleteOrder(String book, int orderId) {
        this.books.get(book).deleteOrder(orderId);
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
