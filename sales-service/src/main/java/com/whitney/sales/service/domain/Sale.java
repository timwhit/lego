package com.whitney.sales.service.domain;

import java.math.BigDecimal;

public class Sale {
    private Long id;
    private Long productId;
    private Long userId;
    private Integer quantity;
    private BigDecimal amount;

    public Sale() {}

    public Sale(Long id, Long productId, Long userId, Integer quantity, BigDecimal amount) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}