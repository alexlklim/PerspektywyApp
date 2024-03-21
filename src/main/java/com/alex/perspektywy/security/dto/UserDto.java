package com.alex.perspektywy.security.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;



@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "User DTO")
public class UserDto {
    @Schema(description = "User id", example = "10")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;


    @Schema(description = "Email", example = "alex@gmail.com")
    String email;

    @Schema(description = "First name", example = "Alex")
    private String firstName;

    @Schema(description = "Last name", example = "Klim")
    private String lastName;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Is active", example = "true")
    boolean isActive;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Last activity", example = "2024-03-08 14:30")
    LocalDateTime lastActivity;

    @Schema(description = "Role", example = "ADMIN")
    private String role;
}