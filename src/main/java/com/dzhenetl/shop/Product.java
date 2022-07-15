package com.dzhenetl.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public final class Product {

    private String name;
    private int price;
    private String manufacturer;
    private double rating;
}
