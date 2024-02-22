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

    public Item(String category, String name, double price, double discount, Date date) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
