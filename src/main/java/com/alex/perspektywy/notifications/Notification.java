package com.alex.perspektywy.notifications;


import com.alex.perspektywy.member.domain.Member;
import com.alex.perspektywy.member.domain.admin.enums.Reason;
import com.alex.perspektywy.member.utils.BaseEntity;
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
    private Member member;
}
