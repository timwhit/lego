package com.whitney.sales.data.dao;

import com.whitney.product.web.vo.ProductVO;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

@Validated
@Repository
public class ProductDAOImpl implements ProductDAO {
    private static final String URI = "http://localhost:8083/rest/product/{id}";

    @Override
    public ProductVO findById(Long productId) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(URI, ProductVO.class, productId);
    }
}