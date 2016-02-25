package com.whitney.support.service;

import com.whitney.common.util.MapperUtils;
import com.whitney.support.domain.Support;
import com.whitney.support.data.dao.SalesDAO;
import com.whitney.support.data.dao.SupportDAO;
import com.whitney.support.data.dto.SaleDTO;
import com.whitney.support.data.dto.SupportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
@Service
public class SupportServiceImpl implements SupportService {
    @Autowired
    private SupportDAO supportDAO;

    @Autowired
    private SalesDAO salesDAO;

    @Autowired
    private MapperUtils mapper;

    @Override
    public Support get(Long id) {
        return this.mapper.map(this.supportDAO.findOne(id), Support.class);
    }

    @Override
    public Support create(Support support) {
        //lookup sale to make sure it's valid
        SaleDTO saleDTO = this.salesDAO.findById(support.getSalesId());
        if (saleDTO == null) {
            throw new RuntimeException("Sale couldn't be located");
        }

        SupportDTO supportDTO = this.mapper.map(support, SupportDTO.class);
        supportDTO.setCreatedDate(LocalDateTime.now());
        supportDTO.setModifiedDate(LocalDateTime.now());
        supportDTO.setCreatedUserId(1L);
        supportDTO.setModifiedUserId(1L);

        SupportDTO createdSupport = this.supportDAO.saveAndFlush(supportDTO);

        return this.mapper.map(createdSupport, Support.class);
    }
}