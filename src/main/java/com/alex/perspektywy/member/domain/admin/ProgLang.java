package com.alex.perspektywy.member.domain.admin;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name = "prog_langs")
public class ProgLang {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "prog_lang")
    private String progLang;
}
