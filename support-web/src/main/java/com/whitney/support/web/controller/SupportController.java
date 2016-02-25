package com.whitney.support.web.controller;

import com.whitney.common.util.MapperUtils;
import com.whitney.support.domain.Support;
import com.whitney.support.service.SupportService;
import com.whitney.support.web.vo.SupportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/support")
public class SupportController {
    @Autowired
    private SupportService supportService;

    @Autowired
    private MapperUtils mapper;

    @RequestMapping(value = "/{supportId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public SupportVO get(@PathVariable Long supportId) {
        return this.mapper.map(this.supportService.get(supportId), SupportVO.class);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public SupportVO create(@RequestBody SupportVO support) {
        Support createdSupport = this.supportService.create(this.mapper.map(support, Support.class));

        return this.mapper.map(createdSupport, SupportVO.class);
    }
}