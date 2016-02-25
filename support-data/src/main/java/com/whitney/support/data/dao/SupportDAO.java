package com.whitney.support.data.dao;

import com.whitney.support.data.dto.SupportDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupportDAO extends JpaRepository<SupportDTO, Long> {

}