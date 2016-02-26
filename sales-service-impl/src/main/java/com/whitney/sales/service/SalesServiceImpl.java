package com.whitney.sales.service;

import com.whitney.common.messaging.MessageQueue;
import com.whitney.common.messaging.MessageSender;
import com.whitney.common.util.MapperUtils;
import com.whitney.product.web.vo.ProductVO;
import com.whitney.sales.data.dao.ProductDAO;
import com.whitney.sales.data.dao.SalesDAO;
import com.whitney.sales.data.dto.SaleDTO;
import com.whitney.sales.service.domain.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
@Transactional
@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesDAO salesDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private MapperUtils mapper;

    @Autowired
    private MessageSender messageSender;

    @Override
    public Sale get(Long id) {
        return this.mapper.map(this.salesDAO.findOne(id), Sale.class);
    }

    @Override
    public Sale create(Sale sale) {
        //call product service to check on inventory
        ProductVO product = this.productDAO.findById(sale.getProductId());
        if (product.getInventory() < sale.getQuantity()) {
            throw new RuntimeException("Not enough inventory available for sale.");
        }

        SaleDTO saleDTO = this.mapper.map(sale, SaleDTO.class);
        saleDTO.setCreatedDate(LocalDateTime.now());
        saleDTO.setModifiedDate(LocalDateTime.now());
        saleDTO.setCreatedUserId(1L);
        saleDTO.setModifiedUserId(1L);

        SaleDTO savedSale = this.salesDAO.saveAndFlush(saleDTO);

        Sale completedSale = this.mapper.map(savedSale, Sale.class);

        //send message to queue saying the sale was completed
        this.messageSender.sendMessage(completedSale, MessageQueue.SALE_CREATED);

        return completedSale;
    }
}