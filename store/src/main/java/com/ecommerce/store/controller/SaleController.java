package com.ecommerce.store.controller;

import com.ecommerce.store.dto.SaleDTO;
import com.ecommerce.store.model.Product;
import com.ecommerce.store.model.Sale;
import com.ecommerce.store.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/api/sales")
public class SaleController {
    @Autowired
    private ISaleService saleService;

    @PostMapping(path="/save")
    public String saveSale(@RequestBody Sale sale){
        this.saleService.saveSale(sale);
        return "Success";
    }

    @GetMapping(path="/find")
    @ResponseBody
    public Sale findSaleById(@RequestParam int saleId){
        return this.saleService.findSaleById(saleId);
    }

    @GetMapping(path="/find-all")
    @ResponseBody
    public List<Sale> getAllSales(){
        return this.saleService.getAllSales();
    }

    @DeleteMapping(path="/delete")
    @ResponseBody
    public Sale deleteSaleById(@RequestParam int saleId){
        return this.saleService.deleteSaleById(saleId);
    }

    @PutMapping(path="/update")
    @ResponseBody
    public Sale updateSale(@RequestBody Sale sale){

        return this.saleService.updateSale(sale);
    }

    @GetMapping(path="/products")
    @ResponseBody
    public List<Product> getAllProducts(@RequestParam int saleId){
        return this.saleService.getAllProducts(saleId);
    }

    @GetMapping(path="/sale-info")
    public String getSaleInfo(){
        return this.saleService.getSaleInfo();
    }

    @GetMapping(path="/max-sale")
    @ResponseBody
    public SaleDTO findMaxSale(){
        return this.saleService.findMaxSale();
    }
}
