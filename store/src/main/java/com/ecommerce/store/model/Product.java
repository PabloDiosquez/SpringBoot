package com.ecommerce.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Product {
    private int productId;
    private String name;
    private String brand;
    private double cost;
    private int availableQuantity;
}
