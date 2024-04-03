package com.alex.perspektywy.users.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum Specialization {

    COMPUTER_SCIENCE("Computer Science"),
    SOFTWARE_ENGINEERING("Software Engineering"),
    INFORMATION_TECHNOLOGY("Information Technology"),
    ELECTRICAL_ENGINEERING("Electrical Engineering"),
    MECHANICAL_ENGINEERING("Mechanical Engineering"),
    CIVIL_ENGINEERING("Civil Engineering"),
    BIOMEDICAL_ENGINEERING("Biomedical Engineering"),
    CHEMICAL_ENGINEERING("Chemical Engineering"),
    AEROSPACE_ENGINEERING("Aerospace Engineering"),
    INDUSTRIAL_ENGINEERING("Industrial Engineering"),
    TELECOMMUNICATIONS_ENGINEERING("Telecommunications Engineering"),
    SYSTEMS_ENGINEERING("Systems Engineering");

    private final String specializationName;

    Specialization(String specializationName) {
        this.specializationName = specializationName;
    }


    public static Specialization fromString(String specializationName) {
        for (Specialization specialization : Specialization.values()) {
            if (specialization.getSpecializationName().equalsIgnoreCase(specializationName)) {
                return specialization;
            }
        }
        throw new IllegalArgumentException("No enum constant with specialization name: " + specializationName);
    }
    public static List<String> getAll() {
        return Arrays.stream(Specialization.values())
                .map(Specialization::getSpecializationName)
                .collect(Collectors.toList());
    }

    public String getSpecializationName() {
        return specializationName;
    }
}
