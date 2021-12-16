package com.beans;

import java.util.Comparator;

public class Temp implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Integer.parseInt(o2.getPrice()) - Integer.parseInt(o1.getPrice());
    }

}
