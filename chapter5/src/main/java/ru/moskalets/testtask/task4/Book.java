package ru.moskalets.testtask.task4;

import java.util.*;

/**
 * Класс Book - реализует тип ценной бумаги.
 */
public class Book {
    /**
     * bookName - наименование ценной бумаги.
     */
    private String bookName;
    /**
     * sellOrders - Заявки на прадажу данной ценной бумаги.
     */
    private Map<Integer, Order> sellOrders = new HashMap<Integer, Order>();
    /**
     * buyOrders - Заявки на пакупку данной ценной бумаги.
     */
    private Map<Integer, Order> buyOrders = new HashMap<Integer, Order>();
    /**
     * bid - заявки на пакупку, отсортированные по убыванию цены.
     */
    private TreeSet<Order> bid;
    /**
     * ask - заявки на продажу, отсортированный по убыванию цены.
     */
    private TreeSet<Order> ask;
    /**
     * Операция- продажа.
     */
    private static final String SELL = "SELL";
    /**
     * Операция - покупка.
     */
    private static final String BUY = "BUY";

    /**
     * Конструктор.
     * @param bookName
     */
    public Book(String bookName) {
        this.bookName = bookName;
    }

    /**
     * Добавление новой заявки.
     * @param order
     */
    public void setOrder(Order order) {
        if (this.SELL.equals(order.getOperation())) {
            sellOrders.put(order.getOrderId(), order);
        }
        if (this.BUY.equals(order.getOperation())) {
            buyOrders.put(order.getOrderId(), order);
        }
    }

    /**
     * Удаление заявки.
     * @param orderId
     */
    public void deleteOrder(int orderId) {
        if (this.sellOrders.containsKey(orderId)) {
            sellOrders.remove(orderId);
        } else {
            if (this.buyOrders.containsKey(orderId)) {
                buyOrders.containsKey(orderId);
            }
        }
    }

    /**
     * Сортировка заявок и их покупка/продажа.
     */
    public void sellAndBuy() {
        this.bid = new TreeSet<Order>(new TreeSetComparator());
        this.ask = new TreeSet<Order>(new TreeSetComparator());
        for (Order order: this.buyOrders.values()) {
            this.bid.add(order);
        }
        for (Order order: this.sellOrders.values()) {
            this.ask.add(order);
        }
        Iterator<Order> iterBid = this.bid.iterator();
        Iterator<Order> iterAsk = this.ask.iterator();
        Order orderBid = iterBid.next();
        Order orderAsk = iterAsk.next();
        while (iterAsk.hasNext() & iterBid.hasNext()) {
            if (orderBid.getPrice() >= orderAsk.getPrice()) {
                if (orderBid.getVolume() > orderAsk.getVolume()) {
                    orderBid.setVolume(orderBid.getVolume() - orderAsk.getVolume());
                    iterAsk.remove();
                    orderAsk = iterAsk.next();
                } else {
                    if (orderBid.getVolume() == orderAsk.getVolume()) {
                        iterBid.remove();
                        orderBid = iterBid.next();
                        iterAsk.remove();
                        orderAsk = iterAsk.next();
                    } else {
                        orderAsk.setVolume(orderAsk.getVolume() - orderBid.getVolume());
                        iterBid.remove();
                        orderBid = iterBid.next();
                    }
                }
            } else {
                orderAsk = iterAsk.next();
            }
        }
    }

    /**
     * Печать биржевого стакана ценной бумаги.
     */
    public void printBook() {
        this.sellAndBuy();
        System.out.printf("%16s%n", this.bookName);
        System.out.printf("%-10s%-12s%-10s%n", "Cell", "Price", "Buy");
        for (Order order: this.ask) {
            System.out.printf("%-10d%-12.2f%-10d%n", order.getVolume(), order.getPrice(), 0);
        }
        for (Order order: this.bid) {
            System.out.printf("%-10d%-12.2f%-10d%n", 0, order.getPrice(), order.getVolume());
        }
    }

    /**
     * Возвращает заявки на продажу.
     * @return
     */
    public Map getSellOrders() {
        return this.sellOrders;
    }

    /**
     * Возвращает заявки на покупку.
     * @return
     */
    public Map getBuyOrders() {
        return this.buyOrders;
    }
    /**
     * Класс компратор - сортирует заявки по убыванию поля price.
     */
    private class TreeSetComparator implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            return Double.compare(o2.getPrice(), o1.getPrice());
        }
    }
}
