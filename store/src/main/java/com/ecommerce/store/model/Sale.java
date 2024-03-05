package com.ecommerce.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Sale {
    private int saleId;
    private LocalDate date;
    private double total;
    private List<Product> products;
    private Client client;
}
