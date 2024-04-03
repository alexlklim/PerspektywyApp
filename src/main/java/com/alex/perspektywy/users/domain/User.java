package com.alex.perspektywy.users.domain;

import com.alex.perspektywy.security.domain.Role;
import com.alex.perspektywy.users.domain.enums.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "user_skills",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills;



    @Column(name = "last_activity")
    LocalDateTime lastActivity;

    @CreatedDate
    LocalDateTime created;
    @LastModifiedDate
    LocalDateTime updated;

    @Column(name = "is_active")
    boolean isActive;


    @Column(name = "first_name")
    String firstname;

    @Column(name = "last_name")
    String lastname;

    @Column(unique = true)
    String email;
    String password;

    @Enumerated(EnumType.STRING)
    private Role roles;


    @Column(name = "about_me")
    String aboutMe;

    @Column(name = "born_year")
    Integer bornYear;

    Double longitude;
    Double latitude;

    @Column(name = "experience_years")
    Integer experienceYears;

    @Enumerated(EnumType.STRING)
    City city;

    @Column(name = "experience_level")
    @Enumerated(EnumType.STRING)
    ExperienceLevel experienceLevel;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_statuses",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    List<UserStatus> userStatuses;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_programming_langs",
            joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "programming_lang")
    @Enumerated(EnumType.STRING)
    List<ProgrammingLang> programmingLangs;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_speaking_langs",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "speaking_lang")
    private List<SpeakingLang> speakingLangs;







    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
