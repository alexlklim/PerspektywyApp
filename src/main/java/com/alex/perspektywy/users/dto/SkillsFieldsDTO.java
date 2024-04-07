package com.alex.perspektywy.users.dto;

import com.alex.perspektywy.users.domain.enums.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "Skills DTO with possible fields")
public class SkillsFieldsDTO {

    List<String> cities;
    List<String> experienceLevels;
    List<String> programmingLangs;
    List<String> speakingLangs;
    List<String> userStatuses;

}
