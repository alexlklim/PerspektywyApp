package com.alex.perspektywy.member.domain;


import com.alex.perspektywy.member.domain.admin.ProgLang;
import com.alex.perspektywy.member.domain.admin.SpeakLang;
import com.alex.perspektywy.member.domain.admin.enums.Level;
import com.alex.perspektywy.member.domain.skills.Skill;
import com.alex.perspektywy.image.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    boolean isActive;

    String fio;
    String aboutMe;
    Integer bornYear;

    String country;
    String city;


    Long longitude;
    Long latitude;

    @Enumerated(EnumType.STRING)
    Level level;

    boolean isMentor;
    boolean isMentee;
    boolean isOpenForEvents;
    boolean isOpenForProjects;
    boolean isVisibleOnMap;

    @OneToOne(fetch = FetchType.EAGER)
    Image imageId;



    @ManyToMany
    @JoinTable(
            name = "user_prog_langs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "prog_lang_id"))
    List<ProgLang> progLangs;



    @ManyToMany
    @JoinTable(
            name = "user_speak_langs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "speak_lang_id"))
    List<SpeakLang> speakLangs;



    @ManyToMany
    @JoinTable(
            name = "user_skills",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    List<Skill> skills;



}
