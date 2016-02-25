package com.whitney.sales.web.controller;

import com.whitney.common.util.MapperUtils;
import com.whitney.sales.service.SalesService;
import com.whitney.sales.service.domain.Sale;
import com.whitney.sales.web.vo.SaleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @Autowired
    private MapperUtils mapper;

    @RequestMapping(value = "/{salesId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SaleVO get(@PathVariable Long salesId) {
        return this.mapper.map(this.salesService.get(salesId), SaleVO.class);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public SaleVO create(@RequestBody SaleVO sale) {
        Sale createdSale = this.salesService.create(this.mapper.map(sale, Sale.class));

        return this.mapper.map(createdSale, SaleVO.class);
    }
}