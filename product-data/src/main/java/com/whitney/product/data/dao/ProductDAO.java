package com.whitney.product.data.dao;

import com.whitney.product.data.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<ProductDTO, Long> {

}