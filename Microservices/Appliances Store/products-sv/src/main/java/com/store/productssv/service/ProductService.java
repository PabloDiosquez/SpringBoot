package com.store.productssv.service;

import com.store.productssv.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProductByCode(int code);
    Optional<List<Product>> getAllProducts();
    Optional<Product> deleteProductByCode(int code);
    Optional<Product> updateProduct(int code, Product product);
}
