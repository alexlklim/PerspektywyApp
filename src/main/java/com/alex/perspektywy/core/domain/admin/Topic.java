package com.alex.perspektywy.core.domain.admin;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "topics")
public class Topic {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
}
