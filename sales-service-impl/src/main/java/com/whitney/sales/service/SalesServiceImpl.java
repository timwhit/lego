package com.whitney.sales.service;

import com.whitney.common.util.MapperUtils;
import com.whitney.sales.data.dao.SalesDAO;
import com.whitney.sales.data.dto.SaleDTO;
import com.whitney.sales.service.domain.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesDAO salesDAO;

    @Autowired
    private MapperUtils mapper;

    @Override
    public Sale get(Long id) {
        return this.mapper.map(this.salesDAO.findOne(id), Sale.class);
    }

    @Override
    public Sale create(Sale sale) {
        //call product service to check on inventory

        SaleDTO saleDTO = this.mapper.map(sale, SaleDTO.class);

        SaleDTO savedSale = this.salesDAO.saveAndFlush(saleDTO);

        //send message to queue saying the sale was completed

        return null;
    }
}