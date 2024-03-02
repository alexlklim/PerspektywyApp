package com.alex.perspektywy.member.domain.admin;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "universities")
public class University {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String university;
}
