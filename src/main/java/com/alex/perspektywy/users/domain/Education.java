package com.alex.perspektywy.users.domain;

import com.alex.perspektywy.security.domain.User;
import com.alex.perspektywy.users.domain.enums.Degree;
import com.alex.perspektywy.users.domain.enums.Specialization;
import com.alex.perspektywy.users.domain.enums.Universities;
import com.alex.perspektywy.utils.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "educations") @Entity
public class Education extends BaseEntity {

    boolean isCurrent;
    
    LocalDate startDate;
    LocalDate finishDate;


    @Enumerated(EnumType.STRING)
    Degree degree;

    @Enumerated(EnumType.STRING)
    Specialization specialization;

    @Enumerated(EnumType.STRING)
    Universities universities;

    @ManyToOne
    User user;

}
