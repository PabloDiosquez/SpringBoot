package com.ecommerce.store.service;

import com.ecommerce.store.model.Sale;
import com.ecommerce.store.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements ISaleService{
    @Autowired
    private ISaleRepository saleRepository;

    @Override
    public void saveSale(Sale sale) {
        this.saleRepository.save(sale);
    }

    @Override
    public Sale findSaleById(int saleId) {
        return this.saleRepository.findById(saleId).orElse(null);
    }
}
