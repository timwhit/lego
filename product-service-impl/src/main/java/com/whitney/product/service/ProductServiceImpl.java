package com.whitney.product.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whitney.common.messaging.MessageQueue;
import com.whitney.common.util.MapperUtils;
import com.whitney.product.data.dao.ProductDAO;
import com.whitney.product.data.dto.ProductDTO;
import com.whitney.product.domain.Product;
import com.whitney.sales.web.vo.SaleVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.time.LocalDateTime;

@Validated
@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private MapperUtils mapper;

    @Autowired
    private ObjectMapper objectMapper;

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

    @Override
    @JmsListener(destination = MessageQueue.SALE_CREATED)
    public void processCompletedSale(String data) {
        LOG.info("JMS Message Received: {}", data);

        SaleVO sale;

        try {
            sale = this.objectMapper.readValue(data, SaleVO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ProductDTO productDTO = this.productDAO.findOne(sale.getProductId());
        productDTO.setInventory(productDTO.getInventory() - sale.getQuantity());

        this.productDAO.saveAndFlush(productDTO);

        LOG.info("Product ID: [{}] inventory reduced to [{}]", productDTO.getId(), productDTO.getInventory());
    }
}