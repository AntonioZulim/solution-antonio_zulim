package com.zulim_antonio.abysalto_test.service;

import org.springframework.stereotype.Service;

import com.zulim_antonio.abysalto_test.client.ProductClient;
import com.zulim_antonio.abysalto_test.dto.ProductDto;
import com.zulim_antonio.abysalto_test.dto.ProductListDto;

@Service
public class ProductService {
    private final ProductClient productClient;

    public ProductService(ProductClient productClient) {
        this.productClient = productClient;
    }
    
    public ProductDto getProductById(Long id){
        return productClient.getProduct(id);
    }

    public ProductListDto getProductList(){
        return productClient.getAllProducts();
    }
}
