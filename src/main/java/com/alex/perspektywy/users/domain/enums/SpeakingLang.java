package com.alex.perspektywy.users.domain.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SpeakingLang {
    POLISH, ENGLISH, GERMAN, FRENCH, SPANISH, ITALIAN, RUSSIAN;

    public static SpeakingLang fromString(String speakingLangName) {
        for (SpeakingLang speakingLang : SpeakingLang.values()) {
            if (speakingLang.name().equalsIgnoreCase(speakingLangName)) {
                return speakingLang;
            }
        }
        throw new IllegalArgumentException("No enum constant " + speakingLangName + " found in SpeakingLang");
    }


    public static List<String> getAll() {
        return Arrays.stream(SpeakingLang.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
