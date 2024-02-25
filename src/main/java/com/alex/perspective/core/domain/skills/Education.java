package com.alex.perspective.core.domain.skills;


import com.alex.perspective.core.domain.User;
import com.alex.perspective.core.domain.admin.Specialization;
import com.alex.perspective.core.domain.admin.University;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "educations")
public class Education {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    boolean isCurrent;
    LocalDate startDate;
    LocalDate endDate;


    String degree;

    @ManyToOne @JoinColumn(name = "university_id")
    University university;

    @ManyToOne @JoinColumn(name = "specialization_id")
    Specialization specialization;


    @ManyToOne @JoinColumn(name = "member_id")
    User user;
}
