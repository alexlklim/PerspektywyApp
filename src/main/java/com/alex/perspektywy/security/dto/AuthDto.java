package com.alex.perspektywy.security.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "Auth DTO")
public class AuthDto {

    @Schema(description = "First name", example = "Alex")
    private String firstName;

    @Schema(description = "Last name", example = "Klim")
    private String lastName;

    @Schema(description = "Time expiration", example = "2024-03-08 14:30")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expiresAt;

    private List<String> role = new ArrayList<>();

    @Schema(description = "Access token", example = "eyJhbJ9.eyJzdWyfQ.Sflsw5c")
    private String accessToken;

    @Schema(description = "Refresh token", example = "d133f77b-21c5-4ecf-8576-9b79e7d46be7")
    private UUID refreshToken;
}
