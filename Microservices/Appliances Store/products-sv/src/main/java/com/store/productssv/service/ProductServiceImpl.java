package com.store.productssv.service;

import com.store.productssv.model.Product;
import com.store.productssv.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    @Override
    public Optional<Product> getProductByCode(int code) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getAllProducts() {
        return Optional.empty();
    }

    @Override
    public Optional<Product> deleteProductByCode(int code) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> updateProduct(int code, Product product) {
        return Optional.empty();
    }
}
