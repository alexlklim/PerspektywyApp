package com.alex.perspektywy.core.domain.admin;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "speak_langs")
public class SpeakLang {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "speak_lang")
    private String speakLang;

}
