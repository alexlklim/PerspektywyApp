package com.alex.perspective.auth;


import com.alex.perspective.core.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tokens")
public class Token {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public UUID token;

    @CreatedDate
    public LocalDateTime created;

    @LastModifiedDate
    public LocalDateTime expired;


    @OneToOne(fetch = FetchType.EAGER)
    public User user;
}
