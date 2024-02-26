package com.alex.perspektywy.core.domain;


import com.alex.perspektywy.core.domain.admin.enums.Level;
import com.alex.perspektywy.core.domain.admin.ProgLang;
import com.alex.perspektywy.core.domain.skills.Skill;
import com.alex.perspektywy.core.utils.Comment;
import com.alex.perspektywy.core.domain.admin.Topic;
import com.alex.perspektywy.core.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "projects")
public class Project extends BaseEntity {

    boolean isFinished;
    boolean isProjectPublic;
    boolean isOpenForParticipants;
    boolean isOnlyForProgrammers;
    boolean isLocationImportant;

    String title;
    String description;
    String city;


    LocalDate startDate;
    Integer duration;

    @Enumerated(EnumType.STRING)
    Level level;

    @ManyToOne @JoinColumn(name = "topic_id")
    Topic topic;

    @ManyToOne @JoinColumn(name = "author_id")
    Member author;



    @ManyToMany
    @JoinTable(
            name = "project_prog_langs",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "prog_lang_id"))
    List<ProgLang> progLangs;



    @ManyToMany
    @JoinTable(
            name = "project_skills",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    List<Skill> skills;

    @ManyToMany
    @JoinTable(
            name = "project_members",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<Member> members;



    @ManyToMany
    @JoinTable(
            name = "project_comments",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    List<Comment> comments;


}
