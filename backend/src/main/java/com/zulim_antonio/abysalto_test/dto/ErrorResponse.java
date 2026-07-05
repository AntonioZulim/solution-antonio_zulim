package com.zulim_antonio.abysalto_test.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Standard error response returned for failed requests")
public record ErrorResponse(
        @Schema(description = "Machine-readable error code", example = "CATEGORY_NOT_FOUND")
        String type,

        @Schema(description = "Human-readable error message", example = "Category electronics does not exist")
        String message
) {}
