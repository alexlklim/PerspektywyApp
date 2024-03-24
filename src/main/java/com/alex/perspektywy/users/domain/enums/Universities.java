package com.alex.perspektywy.users.domain.enums;

import lombok.Getter;

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

}
