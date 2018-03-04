package ru.moskalets.testtask.task4;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * Created by Пользователь on 04.03.2018.
 */
public class BookTest {
    /**
     * Если добавить ордер с операцией SELL, то он добавиться в sellOrders.
     */
    @Test
    public void whenAddOrderSellReturnSizeOne() {
        Book book = new Book("book-1");
        Order orderSell = new Order("Book-1", "SELL", 10.00, 50, 1);
        book.setOrder(orderSell);
        assertThat(book.getSellOrders().size(), is(1));
    }

    /**
     * Если добавить ордер с операцией BUY, то он добавиться в buyOrders.
     */
    @Test
    public void whenAddOrderBuyReturnSizeOne() {
        Book book = new Book("book-1");
        Order orderBuy = new Order("Book-1", "BUY", 10.00, 50, 1);
        book.setOrder(orderBuy);
        assertThat(book.getBuyOrders().size(), is(1));
    }
}