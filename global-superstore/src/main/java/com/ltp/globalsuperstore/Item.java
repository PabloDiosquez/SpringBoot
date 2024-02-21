package com.ltp.globalsuperstore;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Item {
    private String category;
    private String name;
    private double price;
    private double discount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Item() {
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
