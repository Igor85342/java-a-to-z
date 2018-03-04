package ru.moskalets.testtask.task4;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
/**
 * Класс тестриует класс OrderBook
 */
public class OrderBookTest {
    /**
     * Запускает исполнение программы.
     * @throws IOException
     */
    @Test
    public void testParcingFile() throws ParserConfigurationException, IOException, SAXException {
        String source = "C:\\Projects\\java-a-to-z\\chapter5\\src\\main\\java\\ru\\moskalets\\testtask\\task4\\orders.xml";
        OrderBook ob = new OrderBook(source);
        ob.parsingFile();
        ob.printAllBooks();
    }
}