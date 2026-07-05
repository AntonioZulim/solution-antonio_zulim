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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Retreiving and filtering products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @Operation(summary = "Get product by ID", description = "Returns a single product based on its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Product found",
            content = @Content(schema = @Schema(implementation = ProductDto.class))),
        @ApiResponse(responseCode = "404", description = "Product not found",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "503", description = "Product service is currently unavailable",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Unexpected internal error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @Operation(summary = "Get products with optional filters",
               description = "Returns a list of products, optionally filtered by category and price range")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of products",
            content = @Content(schema = @Schema(implementation = ProductSummaryDto.class))),
        @ApiResponse(responseCode = "404", description = "Category does not exist",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "503", description = "Product service is currently unavailable",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Unexpected internal error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
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

    @Operation(summary = "Search products by name", description = "Returns products whose name matches the given search term")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of matching products",
            content = @Content(schema = @Schema(implementation = ProductSummaryDto.class))),
        @ApiResponse(responseCode = "503", description = "Product service is currently unavailable",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Unexpected internal error",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/search")
    public List<ProductSummaryDto> getProductByName(@RequestParam String name) {
        return productService.searchProducts(name);
    }
}
