package com.joumer.dummyproject.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class User {
    @Schema(example = "1001")
    private Long id;

    @Schema(example = "Mustafa")
    private String name;

    @Schema(example = "2023-07-25")
    private LocalDateTime createdDate;
}
