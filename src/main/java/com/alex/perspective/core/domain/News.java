package com.alex.perspective.core.domain;


import com.alex.perspective.utils.Comment;
import com.alex.perspective.utils.BaseEntity;
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
    private User author;
    private String authorName;


    @ManyToMany
    @JoinTable(
            name = "news_comments",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    List<Comment> comments;
}
