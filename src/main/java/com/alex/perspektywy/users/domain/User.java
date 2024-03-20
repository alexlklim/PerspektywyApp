package com.alex.perspektywy.users.domain;

import com.alex.perspektywy.users.domain.enums.City;
import com.alex.perspektywy.users.domain.enums.ExperienceLevel;
import com.alex.perspektywy.users.domain.enums.Role;
import com.alex.perspektywy.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;


