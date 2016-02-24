package com.whitney.sales.web.controller;

import com.whitney.common.util.MapperUtils;
import com.whitney.sales.service.SalesService;
import com.whitney.sales.web.vo.SaleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @Autowired
    private MapperUtils mapper;

    @RequestMapping(value = "/{saleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SaleVO get(@PathVariable Long saleId) {
        return this.mapper.map(this.salesService.get(saleId), SaleVO.class);
    }
}