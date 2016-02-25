package com.whitney.sales.service;

import com.whitney.sales.service.domain.Sale;

public interface SalesService {
    Sale get(Long id);

    Sale create(Sale sale);
}