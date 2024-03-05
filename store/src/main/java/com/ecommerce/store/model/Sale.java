package com.ecommerce.store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saleId;
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    private double total;
    @OneToMany
    private List<Product> products;
    @OneToOne
    @JoinColumn(name = "clientId", referencedColumnName = "clientId")
    private Client client;
}
