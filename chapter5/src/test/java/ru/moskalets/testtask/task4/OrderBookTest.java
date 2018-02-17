package ru.moskalets.testtask.task4;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
/**
 * Класс тестриует класс OrderBook
 */
public class OrderBookTest {
    /**
     * Тестриует разбивку строки на заявку.
     */
    @Test
    public void testParcingAddOrder() {
        OrderBook ob = new OrderBook();
        Order result = ob.parcingAddOrder("<AddOrder book=\"book-1\" operation=\"SELL\" price=\"100.50\" volume=\"81\" orderId=\"1\" />");
        assertThat(result.getBook(), is("book-1"));
        assertThat(result.getOperation(), is("SELL"));
        assertThat(result.getPrice(), is(100.50));
        assertThat(result.getVolume(), is(81));
        assertThat(result.getOrderId(), is(1));
    }

    /**
     * Запускает исполнение программы.
     * @throws IOException
     */
    @Test
    public void testParcingFile() throws IOException {
        String source = "C:\\Projects\\java-a-to-z\\chapter5\\src\\main\\java\\ru\\moskalets\\testtask\\task4\\orders.xml";
        OrderBook ob = new OrderBook(source);
        ob.parsingFile();
        ob.printAllBooks();
    }
}