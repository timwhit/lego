package com.whitney.support.data.dao;

import com.whitney.support.data.dto.SaleDTO;

public interface SalesDAO {
    SaleDTO findById(Long salesId);
}