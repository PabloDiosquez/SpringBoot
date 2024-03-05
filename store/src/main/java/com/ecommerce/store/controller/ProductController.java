package com.ecommerce.store.controller;

import com.ecommerce.store.service.IClientService;
import com.ecommerce.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;
}
