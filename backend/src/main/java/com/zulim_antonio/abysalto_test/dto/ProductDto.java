package com.zulim_antonio.abysalto_test.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDto(
        Long id,
        String title,
        String description,
        String category,
        Double price,
        Double discountPercentage,
        Double rating,
        Integer stock,
        List<String> tags,
        String brand,
        String sku,
        Integer weight,
        Dimensions dimensions,
        String warrantyInformation,
        String shippingInformation,
        String availabilityStatus,
        List<Review> reviews,
        String returnPolicy,
        Integer minimumOrderQuantity,
        Meta meta,
        List<String> images,
        String thumbnail
) {

    public record Dimensions(
            Double width,
            Double height,
            Double depth
    ) {
    }

    public record Review(
            Integer rating,
            String comment,
            Instant date,
            String reviewerName,
            String reviewerEmail
    ) {
    }

    public record Meta(
            Instant createdAt,
            Instant updatedAt,
            String barcode,
            String qrCode
    ) {
    }
}
