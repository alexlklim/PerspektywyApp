package com.alex.perspektywy.member.domain.skills;


import jakarta.persistence.*;
import lombok.Getter;
@Getter
@Entity
@Table(name = "skills")
public class Skill {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skill;

}