package com.zulim_antonio.abysalto_test.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Wrapper containing a list of products, as returned by the external product source")
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductListDto(
        @Schema(description = "List of products")
        List<ProductDto> products
) {}
