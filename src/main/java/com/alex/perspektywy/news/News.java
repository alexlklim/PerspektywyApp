package com.alex.perspektywy.news;


import com.alex.perspektywy.member.domain.Member;
import com.alex.perspektywy.comments.Comment;
import com.alex.perspektywy.member.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news")
public class News  extends BaseEntity  {

    private String news;


    @ManyToOne @JoinColumn(name = "author_id")
    private Member author;
    private String authorName;


    @ManyToMany
    @JoinTable(
            name = "news_comments",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    List<Comment> comments;
}
