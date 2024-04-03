package com.alex.perspektywy.users.dto;


import com.alex.perspektywy.users.domain.Education;
import com.alex.perspektywy.users.domain.Skill;
import com.alex.perspektywy.users.domain.enums.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "User DTO Representation")
public class UserDTO {

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

    List<Map<String, Boolean>> userStatuses;


    List<Map<String, Boolean>> programmingLangs;

    List<Map<String, Boolean>> speakingLangs;



    List<Map<String, Boolean>> skills;

    List<EducationDTO> educations;

}
