package com.alex.perspective.core.domain;


import com.alex.perspective.core.domain.admin.enums.Level;
import com.alex.perspective.utils.Comment;
import com.alex.perspective.core.domain.admin.enums.EventType;
import com.alex.perspective.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "events")
public class Event extends BaseEntity {

    @Column(name = "is_active")
    private boolean isActive;
    private boolean isOnlineEvent;

    private String title;
    private String description;

    LocalDate startDate;
    Integer duration;


    String city;

    @Enumerated(EnumType.STRING)
    Level level;


    @ManyToOne @JoinColumn(name = "author_id")
    User author;


    @Enumerated(EnumType.STRING)
    EventType eventType;


    @ManyToMany
    @JoinTable(
            name = "event_members",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> members;



    @ManyToMany
    @JoinTable(
            name = "event_comments",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    List<Comment> comments;



}
