package com.meta.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private int id;

    @JsonProperty(value = "c-name")
    private String customerName;

    @JsonProperty(value = "p-name")
    private String productName;

    @JsonProperty(value = "q-value")
    private int quantity;
}
