package com.jsv.rest.model;
/*
 * User: Indika Gunawardana
 * Date: 12/25/18
 * Time: 6:22 AM
 * Copyright(c) 2018 AXIS, LLC.
 */

public class Product {
    String name;
    int qty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
