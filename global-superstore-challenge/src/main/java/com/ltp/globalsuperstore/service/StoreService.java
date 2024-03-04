package com.ltp.globalsuperstore.service;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.model.Item;
import com.ltp.globalsuperstore.repository.StoreRepository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StoreService {
    private StoreRepository storeRepository = new StoreRepository();

    public Item getItem(int index) {
        return index == Constants.NOT_FOUND ? new Item() : storeRepository.getItem(index);
    }

    public List<Item> getItems() {
        return storeRepository.getItems();
    }

    public String updateItem(int index, Item item){
        String status = Constants.SUCCESS_STATUS;
        if (index == Constants.NOT_FOUND) {
            storeRepository.addItem(item);
        } else if (within5Days(item.getDate(), storeRepository.getItem(index).getDate())) {
            storeRepository.setItem(index, item);
        } else {
            status = Constants.FAILED_STATUS;
        }
        return status;
    }

    public int getIndexFromId(String id) {
        for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }
}
