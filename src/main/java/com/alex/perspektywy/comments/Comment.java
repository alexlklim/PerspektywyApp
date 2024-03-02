package com.alex.perspektywy.comments;


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
@Table(name = "comments")
public class Comment extends BaseEntity {

    private boolean isDeleted;
    private String comment;

    @ManyToOne  @JoinColumn(name = "parent_coment_id")
    private Comment parentComment;

    @ManyToOne
    private Member member;

    public Comment(String comment, Member member) {
        this.isDeleted = false;
        this.comment = comment;
        this.parentComment = null;
        this.member = member;
    }
}
