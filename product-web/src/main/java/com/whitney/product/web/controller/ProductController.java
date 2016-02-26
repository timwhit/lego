package com.whitney.product.web.controller;

import com.whitney.common.util.MapperUtils;
import com.whitney.product.domain.Product;
import com.whitney.product.service.ProductService;
import com.whitney.product.web.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private MapperUtils mapper;

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductVO get(@PathVariable Long productId) {
        return this.mapper.map(this.productService.get(productId), ProductVO.class);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductVO create(@RequestBody ProductVO product) {
        Product createdProduct = this.productService.create(this.mapper.map(product, Product.class));

        return this.mapper.map(createdProduct, ProductVO.class);
    }
}