package com.alex.perspective.utils;


import com.alex.perspective.core.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "messages")
public class Message extends BaseEntity {
    private boolean isDeleted;
    private String message;

    @ManyToOne  @JoinColumn(name = "user_from_id")
    private User userFrom;

    @ManyToOne  @JoinColumn(name = "user_to_id")
    private User userTo;

}
