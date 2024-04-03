package com.alex.perspektywy.users.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public enum Universities {
    PJATK("Polsko Japońska Akademia Technik Komputerowych"),
    AGH("Akademia Górniczo-Hutnicza"),
    UJ("Uniwersytet Jagielloński"),
    PW("Politechnika Warszawska"),
    UWr("Uniwersytet Wrocławski"),
    UW("Uniwersytet Warszawski"),
    UMCS("Uniwersytet Marii Curie-Skłodowskiej"),
    UEK("Uniwersytet Ekonomiczny w Krakowie"),
    UG("Uniwersytet Gdański"),
    PUT("Politechnika Poznańska"),
    KUL("Katolicki Uniwersytet Lubelski");

    private final String fullName;

    Universities(String fullName) {
        this.fullName = fullName;
    }


    public static Universities fromString(String fullName) {
        for (Universities university : Universities.values()) {
            if (university.getFullName().equalsIgnoreCase(fullName)) {
                return university;
            }
        }
        throw new IllegalArgumentException("No enum constant with full name: " + fullName);
    }

    public static List<String> getAll() {
        return Arrays.stream(Universities.values())
                .map(Universities::getFullName)
                .collect(Collectors.toList());
    }

}
