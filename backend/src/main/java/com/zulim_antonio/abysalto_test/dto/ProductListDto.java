package com.zulim_antonio.abysalto_test.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductListDto(
    List<ProductDto> products
) {}
