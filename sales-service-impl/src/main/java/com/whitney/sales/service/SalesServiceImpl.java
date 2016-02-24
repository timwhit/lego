package com.whitney.sales.service;

import com.whitney.common.util.MapperUtils;
import com.whitney.sales.data.dao.SalesDAO;
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
}