package com.zulim_antonio.abysalto_test.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Detailed product information")
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDto(
        @Schema(description = "Unique product identifier", example = "1")
        Long id,

        @Schema(description = "Product name", example = "Essence Mascara Lash Princess")
        String title,

        @Schema(description = "Detailed product description", example = "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects.")
        String description,

        @Schema(description = "Product category slug", example = "beauty")
        String category,

        @Schema(description = "Product price in USD", example = "9.99")
        Double price,

        @Schema(description = "Discount percentage currently applied", example = "10.48")
        Double discountPercentage,

        @Schema(description = "Average customer rating (0-5)", example = "2.56")
        Double rating,

        @Schema(description = "Number of units currently in stock", example = "99")
        Integer stock,

        @Schema(description = "List of tags associated with the product", example = "[\"beauty\", \"mascara\"]")
        List<String> tags,

        @Schema(description = "Product brand name (may be absent for some categories, e.g. groceries)",
                example = "Essence", nullable = true)
        String brand,

        @Schema(description = "Stock keeping unit code", example = "BEA-ESS-ESS-001")
        String sku,

        @Schema(description = "Product weight (unit not specified by source API)", example = "4")
        Integer weight,

        @Schema(description = "Physical dimensions of the product")
        Dimensions dimensions,

        @Schema(description = "Warranty details (mock data, not tied to product category or type)",
                example = "1 week warranty")
        String warrantyInformation,

        @Schema(description = "Shipping details", example = "Ships in 3-5 business days")
        String shippingInformation,

        @Schema(description = "Current availability status", example = "In Stock")
        String availabilityStatus,

        @Schema(description = "List of customer reviews")
        List<Review> reviews,

        @Schema(description = "Return policy details", example = "No return policy")
        String returnPolicy,

        @Schema(description = "Minimum quantity required per order", example = "48")
        Integer minimumOrderQuantity,

        @Schema(description = "Metadata about the product record")
        Meta meta,

        @Schema(description = "List of image URLs", example = "[\"https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/1.webp\"]")
        List<String> images,

        @Schema(description = "Thumbnail image URL", example = "https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/thumbnail.webp")
        String thumbnail
) {

    @Schema(description = "Physical dimensions of a product")
    public record Dimensions(
            @Schema(description = "Width in centimeters", example = "15.14")
            Double width,

            @Schema(description = "Height in centimeters", example = "13.08")
            Double height,

            @Schema(description = "Depth in centimeters", example = "22.99")
            Double depth
    ) {
    }

    @Schema(description = "Customer review for a product")
    public record Review(
            @Schema(description = "Rating given by the reviewer (1-5)", example = "5")
            Integer rating,

            @Schema(description = "Review comment text", example = "Highly impressed!")
            String comment,

            @Schema(description = "Date and time the review was submitted")
            Instant date,

            @Schema(description = "Name of the reviewer", example = "Eleanor Collins")
            String reviewerName,

            @Schema(description = "Email of the reviewer", example = "eleanor.collins@x.dummyjson.com")
            String reviewerEmail
    ) {
    }

    @Schema(description = "Metadata about the product record")
    public record Meta(
            @Schema(description = "Timestamp when the product record was created")
            Instant createdAt,

            @Schema(description = "Timestamp when the product record was last updated")
            Instant updatedAt,

            @Schema(description = "Barcode value", example = "5784719087687")
            String barcode,

            @Schema(description = "URL to the product's QR code image", example = "https://cdn.dummyjson.com/public/qr-code.png")
            String qrCode
    ) {
    }
}
