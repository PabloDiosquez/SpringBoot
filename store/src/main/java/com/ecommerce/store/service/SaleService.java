package com.ecommerce.store.service;

import com.ecommerce.store.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService implements ISaleService{
    @Autowired
    private ISaleRepository saleRepository;
}