package com.store.productssv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "prod_mark", nullable = false)
    private String mark;

    @Column(name = "price_by_unit", nullable = false)
    private float price;
}
