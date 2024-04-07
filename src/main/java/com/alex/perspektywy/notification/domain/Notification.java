package com.alex.perspektywy.notification.domain;


import com.alex.perspektywy.users.domain.User;
import com.alex.perspektywy.utils.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "notifications")
public class Notification extends BaseEntity {

    @Column(name = "is_active")
    boolean isActive;

    @Column(name = "is_viewed")
    boolean isViewed;

    @Enumerated(EnumType.STRING)
    private Reason reason;

    String message;


    @ManyToOne @JoinColumn(name = "to_user_id")
    User user;

    @ManyToOne @JoinColumn(name = "created_by")
    User createdBy;

}
