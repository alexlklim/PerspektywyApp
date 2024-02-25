package com.alex.perspective.utils;


import com.alex.perspective.core.domain.User;
import com.alex.perspective.core.domain.admin.enums.Reason;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "notifications")
public class Notification extends BaseEntity {

    private String notification;

    @Enumerated(EnumType.STRING)
    private Reason reason;


    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
}
