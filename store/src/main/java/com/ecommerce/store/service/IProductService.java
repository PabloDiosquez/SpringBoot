package com.ecommerce.store.service;

import com.ecommerce.store.model.Product;

import java.util.List;

public interface IProductService {
    void saveProduct(Product product);

    Product findProductById(int productId);

    List<Product> findAllProducts();

    Product deleteProductById(int productId);
}
