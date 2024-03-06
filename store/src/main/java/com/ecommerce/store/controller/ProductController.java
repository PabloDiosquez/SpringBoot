package com.ecommerce.store.controller;

import com.ecommerce.store.model.Product;
import com.ecommerce.store.service.IClientService;
import com.ecommerce.store.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping(path="/save")
    public String saveProduct(@RequestBody Product product){
        this.productService.saveProduct(product);
        return "Success";
    }

    @GetMapping(path="/find")
    @ResponseBody
    public Product findProductById(@RequestParam int productId){
        return this.productService.findProductById(productId);
    }

    @GetMapping(path="/find-all")
    @ResponseBody
    public List<Product> findAllProducts(){
        return this.productService.findAllProducts();
    }

    @DeleteMapping(path="/delete")
    @ResponseBody
    public Product deleteProductById(@RequestParam int productId){
        return this.productService.deleteProductById(productId);
    }

    @PutMapping(path="/update")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product){

        return this.productService.updateProduct(product);
    }

    @GetMapping(path="/out-of-stock")
    @ResponseBody
    public List<Product> outOfStock(){
        return this.productService.outOfStock();
    }
}
