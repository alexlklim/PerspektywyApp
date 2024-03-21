package com.alex.perspektywy.users.domain.enums;

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

    public String getSpecializationName() {
        return specializationName;
    }
}
