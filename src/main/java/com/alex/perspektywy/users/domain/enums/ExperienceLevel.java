package com.alex.perspektywy.users.domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ExperienceLevel {


    JUNIOR,
    MID_LEVEL,
    SENIOR,
    LEAD,
    ARCHITECT,
    PRINCIPAL;



    public static ExperienceLevel fromString(String experienceLevelName) {
        for (ExperienceLevel experienceLevel : ExperienceLevel.values()) {
            if (experienceLevel.name().equalsIgnoreCase(experienceLevelName)) {
                return experienceLevel;
            }
        }
        throw new IllegalArgumentException("No enum constant " + experienceLevelName + " found in ExperienceLevel");
    }

    public static List<String> getAll() {
        return Arrays.stream(ExperienceLevel.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
