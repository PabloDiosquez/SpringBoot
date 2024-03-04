package com.ltp.globalsuperstore.repository;

import com.ltp.globalsuperstore.model.Item;

import java.util.ArrayList;
import java.util.List;

public class StoreRepository {
    List<Item> items = new ArrayList<>();

    public Item getItem(int index) {
        return items.get(index);
    }
    
    public void addItem(Item item) {
        items.add(item);
    }

    public void setItem(int index, Item item) {
        items.set(index, item);
    }

    public List<Item> getItems() {
        return items;
    }
}
