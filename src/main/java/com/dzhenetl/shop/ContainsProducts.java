package com.dzhenetl.shop;


import java.util.List;

// Dependency inversion principle
// Интерфейс который отражает способность хранить и отдавать продукты
// Реализует абстрактный класс Storage (наследники Shop и Basket)
public interface ContainsProducts {

    void addProduct(Product product);

    Product getProduct(String productName);

    void printProducts();

    void removeProduct(String productName);

    List<Product> removeAllProducts();
}
