package com.whitney.product.domain;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String description;
    private BigDecimal amount;
    private Integer inventory;

    public Product() {}

    public Product(Long id, String description, BigDecimal amount, Integer inventory) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.inventory = inventory;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Integer getInventory() {
        return inventory;
    }
}