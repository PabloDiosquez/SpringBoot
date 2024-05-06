package com.store.productssv.service;

import com.store.productssv.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createProduct(Product product);
    Product getProductByCode(int code);
    List<Product> getAllProducts();
    Product deleteProductByCode(int code);
    Product updateProduct(int code, Product product);
}
