package com.whitney.support.domain;

public class Support {
    private Long id;
    private Long salesId;
    private Long productId;
    private Long userId;
    private String description;

    public Support() {}

    public Support(Long id, Long salesId, Long productId, Long userId, String description) {
        this.id = id;
        this.salesId = salesId;
        this.productId = productId;
        this.userId = userId;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Long getSalesId() {
        return salesId;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }
}