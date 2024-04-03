package com.alex.perspektywy.users.services;

import com.alex.perspektywy.users.dto.EducationDTO;
import com.alex.perspektywy.users.dto.EducationFieldsDTO;

import java.util.List;

public interface IEducationService {
    EducationFieldsDTO getEducationFields();

    void updateEducationsForUser(List<EducationDTO> educationDTOList, Long userId);

}
