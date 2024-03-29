package com.ecommerce.store.service;

import com.ecommerce.store.dto.SaleDTO;
import com.ecommerce.store.model.Product;
import com.ecommerce.store.model.Sale;
import com.ecommerce.store.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ISaleService{
    @Autowired
    private ISaleRepository saleRepository;

    @Override
    public void saveSale(Sale sale) {
        this.saleRepository.save(sale);
    }

    @Override
    public Sale findSaleById(int saleId) {
        return this.saleRepository.findById(saleId).orElse(null);
    }

    @Override
    public List<Sale> getAllSales() {
        return this.saleRepository.findAll();
    }

    @Override
    public Sale deleteSaleById(int saleId) {
        Sale sale = this.findSaleById(saleId);
        this.saleRepository.deleteById(saleId);
        return sale;
    }

    @Override
    public Sale updateSale(Sale sale) {
        this.saleRepository.save(sale);
        return this.findSaleById(sale.getSaleId());
    }

    @Override
    public List<Product> getAllProducts(int saleId) {
        return this.findSaleById(saleId).getProducts();
    }

    @Override
    public String getSaleInfo() {
        double total = 0;
        for (Sale sale: this.getAllSales()) {
            total += sale.getTotal();
        }
        return String.format("[Total sales amount: %.2f, Number of sales: %d]", total, this.getAllSales().size());
    }

    @Override
    public SaleDTO findMaxSale() {
        Sale maxSale = this.maxSale();
        return new SaleDTO(maxSale, maxSale.getClient());
    }

    public Sale maxSale(){
        List<Sale> sales = this.getAllSales();
        if(sales.isEmpty()) return null;
        Sale maxSale = sales.get(0);
        for (Sale sale: sales) {
            if(sale.getTotal() > maxSale.getTotal()) maxSale = sale;
        }
        return maxSale;
    }
}
