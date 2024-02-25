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
@Table(name = "comments")
public class Comment extends BaseEntity {

    private boolean isDeleted;
    private String comment;

    @ManyToOne  @JoinColumn(name = "parent_coment_id")
    private Comment parentComment;

    @ManyToOne
    private User user;

    public Comment(String comment, User user) {
        this.isDeleted = false;
        this.comment = comment;
        this.parentComment = null;
        this.user = user;
    }
}
