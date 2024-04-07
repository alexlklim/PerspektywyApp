package com.alex.perspektywy.users.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public enum ProgrammingLang {
    C_PLUS("C++"),
    JAVA("Java"),
    PYTHON("Python"),
    C_SHARP("C#"),
    JAVASCRIPT("JavaScript"),
    RUBY("Ruby"),
    SWIFT("Swift"),
    GO("Go"),
    PHP("PHP"),
    TYPESCRIPT("TypeScript"),
    KOTLIN("Kotlin"),
    RUST("Rust"),
    SCALA("Scala"),
    PERL("Perl"),
    HTML("HTML"),
    CSS("CSS");

    private final String langName;

    ProgrammingLang(String langName) {
        this.langName = langName;
    }


    public static ProgrammingLang fromString(String langName) {
        for (ProgrammingLang lang : values()) {
            if (lang.getLangName().equalsIgnoreCase(langName)) {
                return lang;
            }
        }
        throw new IllegalArgumentException("No enum constant with langName: " + langName);
    }


    public static List<String> getAll() {
        return Arrays.stream(ProgrammingLang.values())
                .map(ProgrammingLang::getLangName)
                .collect(Collectors.toList());
    }

    public String getLangName() {
        return langName;
    }
}
