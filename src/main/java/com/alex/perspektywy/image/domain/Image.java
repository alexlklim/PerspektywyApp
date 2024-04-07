package com.alex.perspektywy.image.domain;

import com.alex.perspektywy.users.domain.User;
import com.alex.perspektywy.utils.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "images")
@Entity
public class Image extends BaseEntity {

    String title;
    String type;

    // created by
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Lob
    @Column(name = "image_data", length = 1000)
    byte[] imageData;

}
