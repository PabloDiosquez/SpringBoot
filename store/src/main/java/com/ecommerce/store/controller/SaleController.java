package com.ecommerce.store.controller;

import com.ecommerce.store.model.Sale;
import com.ecommerce.store.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
