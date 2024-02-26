package com.alex.perspektywy.core.utils;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "images")
public class Image extends BaseEntity {

    private String image;
}
