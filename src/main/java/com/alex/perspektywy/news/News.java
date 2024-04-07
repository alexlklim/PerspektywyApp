package com.alex.perspektywy.news;

import com.alex.perspektywy.users.domain.User;
import com.alex.perspektywy.utils.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "news")
@Entity
public class News extends BaseEntity {


    String title;

    String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;


    @Column(name = "image_id")
    Long imageId;
}
