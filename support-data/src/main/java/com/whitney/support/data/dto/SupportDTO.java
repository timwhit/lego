package com.whitney.support.data.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SUPPORT")
public class SupportDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUPPORT_ID")
    private Long id;
    @Column(name = "SALES_ID")
    private Long salesId;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "DESCRIPTION")
    private String description;
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

    public Long getSalesId() {
        return salesId;
    }

    public void setSalesId(Long salesId) {
        this.salesId = salesId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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