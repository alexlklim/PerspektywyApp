package com.alex.perspektywy.users.domain.enums;

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
}
