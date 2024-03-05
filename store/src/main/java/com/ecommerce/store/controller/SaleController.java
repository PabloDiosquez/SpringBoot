package com.ecommerce.store.controller;

import com.ecommerce.store.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {
    @Autowired
    private ISaleService saleService;
}
