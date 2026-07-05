package com.zulim_antonio.abysalto_test.client;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.zulim_antonio.abysalto_test.dto.CategoryDto;
import com.zulim_antonio.abysalto_test.dto.ProductDto;
import com.zulim_antonio.abysalto_test.dto.ProductListDto;

@HttpExchange(accept = "application/json")
public interface ProductClient {

    @GetExchange("/products/{id}")
    ProductDto getProduct(@PathVariable Long id);
    
    @GetExchange("/products?limit=0")
    ProductListDto getAllProducts();

    @GetExchange("/products/categories")
    List<CategoryDto> getCategories();

    @GetExchange
    ProductListDto getProductsByAbsoluteUrl(URI url);
}
