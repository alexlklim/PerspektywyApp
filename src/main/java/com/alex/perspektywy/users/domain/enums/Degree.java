package com.alex.perspektywy.users.domain.enums;

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

}
