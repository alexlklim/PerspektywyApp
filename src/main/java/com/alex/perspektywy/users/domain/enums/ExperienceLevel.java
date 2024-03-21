package com.alex.perspektywy.users.domain.enums;

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

}
