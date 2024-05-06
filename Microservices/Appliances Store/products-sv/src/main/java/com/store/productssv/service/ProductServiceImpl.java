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
        return productRepository.save(product);
    }

    @Override
    public Product getProductByCode(int code) {
        return unwrappProduct(productRepository.findById(code), code);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product deleteProductByCode(int code) {
        Product product = getProductByCode(code);
        productRepository.deleteById(code);
        return product;
    }

    @Override
    public Product updateProduct(int code, Product product) {
        return updateProduct(getProductByCode(code), product);
    }

    private Product unwrappProduct(Optional<Product> entity, int code){
        if(entity.isPresent()){
            return entity.get();
        }
        throw new RuntimeException("The product with code '" + code + "' does not exist in our records.");
    }

    private Product updateProduct(Product old, Product current){
        old.setName(current.getName());
        old.setMark(current.getMark());
        old.setPrice(current.getPrice());
        return productRepository.save(old);
    }
}
