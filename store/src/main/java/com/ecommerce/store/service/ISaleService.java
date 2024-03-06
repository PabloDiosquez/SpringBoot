package com.ecommerce.store.service;

import com.ecommerce.store.model.Sale;

public interface ISaleService {
    void saveSale(Sale sale);

    Sale findSaleById(int saleId);
}
