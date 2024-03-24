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
@Schema(description = "User DTO Representation")
public class UserV1Represent {

    Long id;

    String firstname;

    String lastname;

    String email;

    String abutMe;

    Integer bornYear;

    Double longitude;
    Double latitude;

    Integer experienceYears;

    City city;

    ExperienceLevel experienceLevel;

    List<UserStatus> userStatuses;

    List<ProgrammingLang> programmingLangs;

    private List<SpeakingLang> speakingLangs;


}