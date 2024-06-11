package com.meta.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRecord(
        int id,
        String customerName,
        String productName,
        int quantity
) {
}
