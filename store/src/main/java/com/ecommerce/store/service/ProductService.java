package com.ecommerce.store.service;

import com.ecommerce.store.model.Product;
import com.ecommerce.store.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product findProductById(int productId) {
        return this.productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product deleteProductById(int productId) {
        Product product = this.findProductById(productId);
        this.productRepository.deleteById(productId);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        this.productRepository.save(product);
        return findProductById(product.getProductId());
    }

    @Override
    public List<Product> outOfStock() {
        final int MIN_STOCK = 5;
        List<Product> products = new ArrayList<>();
        for (Product product: this.findAllProducts()) {
            if(product.getAvailableQuantity() < MIN_STOCK){
                products.add(product);
            }
        }
        return products;
    }
}
