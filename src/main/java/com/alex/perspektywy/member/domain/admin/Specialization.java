package com.alex.perspektywy.member.domain.admin;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "specializations")
public class Specialization {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specialization;
}
