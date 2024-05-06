package com.store.productssv.web;

import com.store.productssv.model.Product;
import com.store.productssv.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{code}")
    public ResponseEntity<Product> getProduct(@PathVariable(name = "code") int code){
        return new ResponseEntity<>(productService.getProductByCode(code), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{code}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "code") int code){
        return new ResponseEntity<>(productService.deleteProductByCode(code), HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{code}")
    public ResponseEntity<Product> updateProduct(@PathVariable(name = "code") int code,
                                                 @RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(code, product), HttpStatus.OK);
    }
}
