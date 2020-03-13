package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Хлеб", 30, "21.04.94"));
        products.add(new Product("Сыр", 120, "21.04.94"));
        products.add(new Product("Молоко", 70, "21.04.94"));
        products.add(new Product("Мясо", 300, "11.04.94"));

        //products.sort();

        class Compar implements Comparator<Product> {

            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getData() > o2.getData())
                    return 1;

                else if (o1.getData() < o2.getData())
                    return -1;
                else return 0;
            }
        }

    }

    int[] cut(String data) {
        String[] b = data.split("\\.");
        int[] a = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            a[i] = Integer.parseInt(b[i]);
        }
return a;
    }

}
