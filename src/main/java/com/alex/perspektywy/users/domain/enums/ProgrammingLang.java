package com.alex.perspektywy.users.domain.enums;

import lombok.Getter;

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


    public static ProgrammingLang getByLangName(String langName) {
        for (ProgrammingLang lang : ProgrammingLang.values()) {
            if (lang.getLangName().equalsIgnoreCase(langName)) {
                return lang;
            }
        }
        throw new IllegalArgumentException("No enum constant with langName: " + langName);
    }
}
