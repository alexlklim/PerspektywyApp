package com.alex.perspektywy.users.mappers;

import com.alex.perspektywy.users.domain.UserEntity;
import com.alex.perspektywy.users.domain.enums.*;
import com.alex.perspektywy.users.dto.UserV1Represent;

import java.util.List;

public class UserMapper {


    UserV1Represent toUserV1Represent(UserEntity user){
        return new UserV1Represent().toBuilder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .abutMe(user.getAbutMe())
                .bornYear(user.getBornYear())
                .longitude(user.getLongitude())
                .latitude(user.getLatitude())
                .experienceLevel(user.getExperienceLevel())
                .city(user.getCity())
                .experienceLevel(user.getExperienceLevel())
                .userStatuses(user.getUserStatuses())
                .programmingLangs(user.getProgrammingLangs())
                .speakingLangs(user.getSpeakingLangs())
                .build();
    }


}
