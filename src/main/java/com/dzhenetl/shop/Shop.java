package com.dzhenetl.shop;

import java.util.*;


// Open-Closed принцип
// класс Shop расширяет Storage, добавляет новые методы
public class Shop extends Storage {

    private final List<Order> orders = new ArrayList<>();

    public Shop(Product... product) {
        stock.addAll(Arrays.asList(product));
    }

    public void completeOrder(Basket basket) {

        List<Product> products = basket.removeAllProducts();
        int totalPrice = 0;
        List<String> productNames = new ArrayList<>();

        for (Product product : products) {
            totalPrice += product.getPrice();
            productNames.add(product.getName());
        }

        Order order = new Order(orders.size() + 1, productNames, totalPrice);
        orders.add(order);
        System.out.println("Заказ оформлен. Номер заказа " + (orders.size()));
    }

    public void completeOrder(int orderNum) {

        Optional<Order> mayBeOrder = orders.stream()
                .filter(o -> o.getOrderNumber() == orderNum)
                .findFirst();

        if (mayBeOrder.isPresent()) {
            Order oldOrder = mayBeOrder.get();
            Order newOrder = new Order(orders.size() + 1,
                    oldOrder.getOrderProducts(),
                    oldOrder.getTotalPrice());
            orders.add(newOrder);
            System.out.println("Заказ оформлен. Номер заказа " + (orders.size()));
        } else {
            throw new NoSuchElementException("Отсутствует заказ с номером " + orderNum);
        }
    }

    public void printOrders() {
        orders.forEach(o ->
                System.out.println(o.getOrderNumber() + ": " + o.getOrderProducts()));
    }
}
