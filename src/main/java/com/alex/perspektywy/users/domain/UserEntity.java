package com.alex.perspektywy.users.domain;

import com.alex.perspektywy.users.domain.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;


@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;




    @Column(name = "first_name")
    String firstname;

    @Column(name = "last_name")
    String lastname;

    @Column(unique = true)
    String email;


    @Column(name = "about_me")
    String abutMe;

    @Column(name = "born_year")
    Integer bornYear;

    Double longitude;
    Double latitude;

    @Column(name = "experience_years")
    Integer experienceYears;

    @Enumerated(EnumType.STRING)
    City city;

    @Column(name = "experience_level")
    @Enumerated(EnumType.STRING)
    ExperienceLevel experienceLevel;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_statuses",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    List<UserStatus> userStatuses;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_programming_langs",
            joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "programming_lang")
    @Enumerated(EnumType.STRING)
    List<ProgrammingLang> programmingLangs;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_speaking_langs",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "speaking_lang")
    private List<SpeakingLang> speakingLangs;


}
