package com.zulim_antonio.abysalto_test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDto(
    Long id,
    String title,
    String description,
    String category,
    Double price,
    String thumbnail
) {}
