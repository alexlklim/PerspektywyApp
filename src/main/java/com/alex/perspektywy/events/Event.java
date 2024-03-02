package com.alex.perspektywy.events;


import com.alex.perspektywy.member.domain.Member;
import com.alex.perspektywy.member.domain.admin.enums.Level;
import com.alex.perspektywy.comments.Comment;
import com.alex.perspektywy.member.utils.BaseEntity;
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
    Member author;


    @Enumerated(EnumType.STRING)
    EventType eventType;


    @ManyToMany
    @JoinTable(
            name = "event_members",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<Member> members;



    @ManyToMany
    @JoinTable(
            name = "event_comments",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    List<Comment> comments;



}
