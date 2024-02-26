package com.alex.perspektywy.core.domain.skills;


import com.alex.perspektywy.core.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "jobs")
public class Job {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    boolean isCurrent;
    LocalDate startDate;
    LocalDate endDate;

    String company;
    String position;


    @ManyToOne  @JoinColumn(name = "member_id")
    Member member;
}
