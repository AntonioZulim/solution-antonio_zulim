package com.zulim_antonio.abysalto_test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zulim_antonio.abysalto_test.client.ProductClient;
import com.zulim_antonio.abysalto_test.dto.CategoryDto;
import com.zulim_antonio.abysalto_test.dto.ProductDto;
import com.zulim_antonio.abysalto_test.dto.ProductSummaryDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class DummyJsonProductServiceTest {
    @Mock
    private ProductClient productClient;

    @InjectMocks
    private DummyJsonProductService productService;

    @Test
    void getProductById_returnsProduct_whenExists() {
        ProductDto mockProduct = new ProductDto(
                1L,                          // id
                "Test Product",              // title
                "Some description",          // description
                "beauty",                    // category
                9.99,                        // price
                10.0,                        // discountPercentage
                4.5,                         // rating
                50,                          // stock
                List.of("tag1", "tag2"),     // tags
                "TestBrand",                 // brand
                "SKU-001",                   // sku
                4,                           // weight
                null,                        // dimensions
                "1 week warranty",           // warrantyInformation
                "Ships in 3-5 days",         // shippingInformation
                "In Stock",                  // availabilityStatus
                List.of(),                   // reviews
                "No return policy",          // returnPolicy
                1,                           // minimumOrderQuantity
                null,                        // meta
                List.of("https://example.com/1.webp"), // images
                "https://example.com/thumb.webp"        // thumbnail
        );

        when(productClient.getProduct(1L)).thenReturn(mockProduct);

        ProductDto result = productService.getProductById(1L);

        assertThat(result).isNotNull();
        assertThat(result.title()).isEqualTo("Test Product");
        verify(productClient, times(1)).getProduct(1L);
    }

    @Test
    void getProducts_returnsEmpty_whenCategoryNotFound() {
        when(productClient.getCategories()).thenReturn(List.of(
            new CategoryDto("beauty", "Beauty", "https://dummyjson.com/products/category/beauty")
        ));

        Optional<List<ProductSummaryDto>> result = productService.getProducts("nonexistent", null, null);

        assertThat(result).isEmpty();
        verify(productClient, never()).getProductsByAbsoluteUrl(any());
    }
}
