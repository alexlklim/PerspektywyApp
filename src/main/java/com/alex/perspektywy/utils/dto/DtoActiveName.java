package com.alex.perspektywy.utils.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "Active Dto Name")
public class DtoActiveName {
    @Schema(description = "Name", example = "Java")
    private String name;

    @Schema(description = "Is active", example = "true")
    private boolean isActive;
}
