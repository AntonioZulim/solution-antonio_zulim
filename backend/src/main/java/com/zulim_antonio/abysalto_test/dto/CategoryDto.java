package com.zulim_antonio.abysalto_test.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Product category information")
public record CategoryDto(
        @Schema(description = "URL-friendly category identifier", example = "beauty")
        String slug,

        @Schema(description = "Human-readable category name", example = "Beauty")
        String name,

        @Schema(description = "URL to fetch all products in this category", example = "https://dummyjson.com/products/category/beauty")
        String url
) {}
