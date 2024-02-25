package com.alex.perspective.auth;


import com.alex.perspective.core.domain.admin.ProgLang;
import com.alex.perspective.core.domain.admin.SpeakLang;
import com.alex.perspective.core.domain.admin.enums.Level;
import com.alex.perspective.core.domain.skills.Skill;
import com.alex.perspective.utils.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    boolean isActive;
    @JsonIgnore @CreatedDate @Column(name = "created")
    Date created;
    @JsonIgnore @LastModifiedDate @Column(name = "updated")
    Date updated;

    String email;
    String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    String fio;

}
