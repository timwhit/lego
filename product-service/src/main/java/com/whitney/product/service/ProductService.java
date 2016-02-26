package com.whitney.product.service;

import com.whitney.product.domain.Product;

public interface ProductService {
    Product get(Long id);

    Product create(Product product);
}