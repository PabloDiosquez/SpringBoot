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
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product getProductByCode(int code) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product deleteProductByCode(int code) {
        return null;
    }

    @Override
    public Product updateProduct(int code, Product product) {
        return null;
    }

    private Product unwrappProduct(Optional<Product> entity, int code){
        if(entity.isPresent()){
            return entity.get();
        }
        throw new RuntimeException("The product with code '" + code + "' does not exist in our records.");
    }
}
