package com.zulim_antonio.abysalto_test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.zulim_antonio.abysalto_test.dto.ErrorResponse;
import com.zulim_antonio.abysalto_test.dto.ProductDto;
import com.zulim_antonio.abysalto_test.dto.ProductSummaryDto;
import com.zulim_antonio.abysalto_test.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public ResponseEntity<?> getProducts(
        @RequestParam(required = false) String category,
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice) {
            Optional<List<ProductSummaryDto>> res = productService.getProducts(category, minPrice, maxPrice);
            if(!res.isPresent()){
                String message = "Category " + category + " does not exist";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("CATEGORY_NOT_FOUND", message));
            }
            return ResponseEntity.ok(res.get());
    }

    @GetMapping("/search")
    public List<ProductSummaryDto> getProductByName(@RequestParam String name) {
        return productService.searchProducts(name);
    }
}
