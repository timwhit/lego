package com.whitney.common.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperUtils extends ModelMapper {
    public MapperUtils() {
        this.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
    }
}