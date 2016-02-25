package com.whitney.support.service;

import com.whitney.support.domain.Support;

public interface SupportService {
    Support get(Long id);

    Support create(Support support);
}