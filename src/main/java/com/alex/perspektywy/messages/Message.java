package com.alex.perspektywy.messages;


import com.alex.perspektywy.member.domain.Member;
import com.alex.perspektywy.member.utils.BaseEntity;
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
    private Member memberFrom;

    @ManyToOne  @JoinColumn(name = "user_to_id")
    private Member memberTo;

}
