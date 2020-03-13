package com.company;

import java.util.Comparator;

public class Product   {
    String name;
    int price;
    String data;

    public Product(String name, int price, String data) {
        this.name = name;
        this.price = price;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getData() {
        return data;
    }

}
