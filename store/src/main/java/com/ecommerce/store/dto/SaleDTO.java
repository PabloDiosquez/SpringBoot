package com.ecommerce.store.dto;

import com.ecommerce.store.model.Client;
import com.ecommerce.store.model.Sale;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SaleDTO {
    private int saleId;
    private double totalAmount;
    private int numberOfProducts;
    private String clientFirstName;
    private String clientLastName;

    public SaleDTO(Sale sale, Client client){
        this.saleId = sale.getSaleId();
        this.totalAmount = sale.getTotal();
        this.numberOfProducts = sale.getProducts().size();
        this.clientFirstName = client.getFirstname();
        this.clientLastName = client.getLastname();
    }
}
