package com.whitney.product.service;

import com.whitney.common.util.MapperUtils;
import com.whitney.product.data.dao.ProductDAO;
import com.whitney.product.data.dto.ProductDTO;
import com.whitney.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private MapperUtils mapper;

    @Override
    public Product get(Long id) {
        return this.mapper.map(this.productDAO.findOne(id), Product.class);
    }

    @Override
    public Product create(Product product) {
        ProductDTO productDTO = this.mapper.map(product, ProductDTO.class);
        productDTO.setCreatedDate(LocalDateTime.now());
        productDTO.setModifiedDate(LocalDateTime.now());
        productDTO.setCreatedUserId(1L);
        productDTO.setModifiedUserId(1L);

        ProductDTO createdProduct = this.productDAO.saveAndFlush(productDTO);

        return this.mapper.map(createdProduct, Product.class);
    }
}