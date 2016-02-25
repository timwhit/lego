package com.whitney.support.data.dao;

import com.whitney.support.data.dto.SaleDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class SalesDAOImpl implements SalesDAO {
    private static final String URI = "http://localhost:8081/rest/sales/{id}";

    @Override
    public SaleDTO findById(Long salesId) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(URI, SaleDTO.class, salesId);
    }
}