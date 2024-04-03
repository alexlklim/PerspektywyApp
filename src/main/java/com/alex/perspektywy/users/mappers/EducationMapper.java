package com.alex.perspektywy.users.mappers;

import com.alex.perspektywy.users.domain.Education;
import com.alex.perspektywy.users.domain.enums.Degree;
import com.alex.perspektywy.users.domain.enums.Specialization;
import com.alex.perspektywy.users.domain.enums.Universities;
import com.alex.perspektywy.users.dto.EducationDTO;

public class EducationMapper {


    public static Education toEntity(EducationDTO dto) {
        Education education = new Education().toBuilder()
                .isCurrent(dto.isCurrent())
                .startDate(dto.getStartDate())
                .degree(Degree.fromString(dto.getDegree()))
                .specialization(Specialization.fromString(dto.getSpecialization()))
                .university(Universities.fromString(dto.getUniversity()))
                .build();
        education.setActive(true);
        if (dto.isCurrent() && dto.getFinishDate() != null)
            education.setFinishDate(dto.getFinishDate());
        return education;

    }


    public static EducationDTO toDto(Education entity) {
        EducationDTO dto = new EducationDTO().toBuilder()
                .id(entity.getId())
                .isCurrent(entity.isCurrent())
                .startDate(entity.getStartDate())
                .degree(entity.getDegree().name())
                .specialization(entity.getSpecialization().getSpecializationName())
                .university(entity.getUniversity().getFullName())
                .build();
        if (entity.isCurrent() && entity.getFinishDate() != null)
            dto.setFinishDate(entity.getFinishDate());
        return dto;

    }
}
