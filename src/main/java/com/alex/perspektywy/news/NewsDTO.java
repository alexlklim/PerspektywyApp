package com.alex.perspektywy.news;


import com.alex.perspektywy.image.domain.Image;
import com.alex.perspektywy.users.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Schema(description = "News Dto")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NewsDTO {

    Long id;
    String title;
    Boolean isActive;

    String description;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String author;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long authorId;

    Long imageId;
}
