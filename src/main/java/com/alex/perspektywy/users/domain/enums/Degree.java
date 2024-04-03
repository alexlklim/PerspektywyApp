package com.alex.perspektywy.users.domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Degree {

    BACHELOR,
    MASTER,
    DOCTORATE,
    ASSOCIATE,
    DIPLOMA,
    CERTIFICATE;


    public static Degree fromString(String degreeName) {
        for (Degree degree : Degree.values()) {
            if (degree.name().equalsIgnoreCase(degreeName)) {
                return degree;
            }
        }
        throw new IllegalArgumentException("No enum constant " + degreeName + " found in Degree");
    }
    public static List<String> getAll() {
        return Arrays.stream(Degree.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
