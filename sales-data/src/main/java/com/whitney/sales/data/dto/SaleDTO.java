package com.whitney.sales.data.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SALES")
public class SaleDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SALES_ID")
    private Long id;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
    @Column(name = "CREATED_USER_ID")
    private Long createdUserId;
    @Column(name = "MODIFIED_DATE")
    private LocalDateTime modifiedDate;
    @Column(name = "MODIFIED_USER_ID")
    private Long modifiedUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(Long modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }
}