package com.zulim_antonio.abysalto_test.service;

import java.util.List;
import java.util.Optional;

import com.zulim_antonio.abysalto_test.dto.ProductDto;
import com.zulim_antonio.abysalto_test.dto.ProductSummaryDto;

public interface ProductService {
    Optional<List<ProductSummaryDto>> getProducts(String category, Double minPrice, Double maxPrice);
    List<ProductSummaryDto> searchProducts(String name);
    ProductDto getProductById(Long id);
}
