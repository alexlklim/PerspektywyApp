package com.alex.perspective.utils;


import com.alex.perspective.utils.BaseEntity;
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
