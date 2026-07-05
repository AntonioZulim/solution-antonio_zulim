package com.zulim_antonio.abysalto_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.zulim_antonio.abysalto_test.dto.ProductDto;
import com.zulim_antonio.abysalto_test.dto.ProductListDto;
import com.zulim_antonio.abysalto_test.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductListDto getProductList() {
        return productService.getProductList();
    }
    
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping(params = {"category", "price"})
    public String getProductByCatAndPrice(@RequestParam(name = "category") String category, @RequestParam(name = "price") Double price) {
        return "filter cat=" + category.toString() + ", price=" + price.toString();
    }

    @GetMapping("/search")
    public String getProductByName(@RequestParam(name = "name") String name) {
        return "filter name=" + name.toString();
    }
}
