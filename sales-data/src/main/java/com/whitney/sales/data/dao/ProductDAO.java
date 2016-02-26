package com.whitney.sales.data.dao;

import com.whitney.product.web.vo.ProductVO;

public interface ProductDAO {
    ProductVO findById(Long productId);
}
