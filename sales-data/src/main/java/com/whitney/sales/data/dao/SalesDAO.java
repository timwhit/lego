package com.whitney.sales.data.dao;

import com.whitney.sales.data.dto.SaleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesDAO extends JpaRepository<SaleDTO, Long> {}