package com.zulim_antonio.abysalto_test.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Condensed product information used in list/search results")
public record ProductSummaryDto(
        @Schema(description = "Thumbnail image URL", example = "https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/thumbnail.webp")
        String thumbnail,

        @Schema(description = "Product name", example = "Essence Mascara Lash Princess")
        String title,

        @Schema(description = "Product price in USD", example = "9.99")
        Double price,

        @Schema(description = "Description truncated to 100 characters, with '...' appended if truncated",
                example = "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthenin...")
        String shortDescription
) {}
