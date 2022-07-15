package com.dzhenetl;

import com.dzhenetl.shop.Basket;
import com.dzhenetl.shop.Product;
import com.dzhenetl.shop.Shop;

import java.util.Scanner;


//Single-responsibility principle
// Программа разделена на классы, которые представляют сущности связанные с магазином
// классы Shop и Basket, которые через интерфейс ContainsProducts умеют хранить продукты
// классы Order и Product - сущности
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(
                new Product("Пиво Майкопское Премиум", 75, "Майкопский пивовареный завод", 5.0),
                new Product("Пиво Майкопское Светлое", 65, "Майкопский пивовареный завод", 4.5),
                new Product("Пиво Майкопское Жигули", 60, "Майкопский пивовареный завод", 4.3),
                new Product("Сыр Адыгейский", 250, "Гиагинский молзавод", 4.7),
                new Product("Соль Адыгейская Абадзехская", 62, "ООО Салина Трейд", 4.7),
                new Product("Щипс Уляпский", 50, "ИП Хуажев А.З.", 4.7)
        );

        System.out.println("Приветствуем в нашем магазине");

        Basket basket = new Basket();
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("1. Показать ассортимент товаров");
            System.out.println("2. Добавить товар в корзину");
            System.out.println("3. Удалить товар из корзины");
            System.out.println("4. Показать товары в корзине");
            System.out.println("5. Оформить заказ");
            System.out.println("6. Показать выполненные заказы");
            System.out.println("7. Повторить заказ");
            System.out.println("8. Выход");

            System.out.print("Введите номер нужной опции: ");
            Scanner scanner = new Scanner(System.in);
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> shop.printProducts();
                case 2 -> {
                    System.out.println("Введите наименование товара");
                    String productName = scanner.nextLine();
                    Product product = shop.getProduct(productName);
                    basket.addProduct(product);
                    System.out.println("В корзину добавлен " + product.getName());
                }
                case 3 -> {
                    System.out.println("Введите наименование товара");
                    String productName = scanner.nextLine();
                    basket.removeProduct(productName);
                    System.out.println("Из корзины удален " + productName);
                }

                case 4 -> basket.printProducts();
                case 5 -> shop.completeOrder(basket);
                case 6 -> shop.printOrders();
                case 7 -> {
                    System.out.println("Введите номер заказа");
                    int orderNum = Integer.parseInt(scanner.nextLine());
                    shop.completeOrder(orderNum);
                }
                case 8 -> {
                    System.out.println("Ждем вас снова!");
                    return;
                }
            }
        }
    }
}
