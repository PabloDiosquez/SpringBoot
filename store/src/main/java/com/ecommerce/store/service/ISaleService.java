package com.ecommerce.store.service;

import com.ecommerce.store.dto.SaleDTO;
import com.ecommerce.store.model.Product;
import com.ecommerce.store.model.Sale;

import java.util.List;

public interface ISaleService {
    void saveSale(Sale sale);

    Sale findSaleById(int saleId);

    List<Sale> getAllSales();

    Sale deleteSaleById(int saleId);

    Sale updateSale(Sale sale);

    List<Product> getAllProducts(int saleId);

    String getSaleInfo();

    SaleDTO findMaxSale();
}
