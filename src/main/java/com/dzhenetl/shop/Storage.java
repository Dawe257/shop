package com.dzhenetl.shop;

import java.util.*;


// принцип DRY
// интерфейс ContainsProducts и абстрактный класс Storage реализован для того,
// чтобы избежать повторения кода одинаковых методов в классах Shop и Basket
// т.к. оба этих класса по сути являются хранилищем продуктов
public abstract class Storage implements ContainsProducts {

    protected List<Product> stock = new ArrayList<>();

    public void addProduct(Product product) {
        stock.add(product);
    }

    public Product getProduct(String productName) {
        Optional<Product> mayBeProduct = stock.stream()
                .filter(x -> x.getName().equals(productName))
                .findFirst();
        if (mayBeProduct.isPresent()) {
            return mayBeProduct.get();
        } else {
            throw new NoSuchElementException(productName + " отсутствует");
        }
    }

    public void removeProduct(String productName) {
        Product product = this.getProduct(productName);
        stock.remove(product);
    }

    public List<Product> removeAllProducts() {
        List<Product> result = new ArrayList<>(stock);
        stock.clear();
        return result;
    }

    public void printProducts() {
        int i = 0;
        for (Product product : stock) {
            System.out.println(i + " " + product.getName() + " - " + product.getPrice());
            i++;
        }
    }
}
