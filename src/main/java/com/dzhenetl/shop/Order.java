package com.dzhenetl.shop;

import lombok.Value;

import java.util.List;

@Value
public class Order {

    int orderNumber;
    List<String> orderProducts;
    int totalPrice;
}
