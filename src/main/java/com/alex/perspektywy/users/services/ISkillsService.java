package com.alex.perspektywy.users.services;

import com.alex.perspektywy.users.domain.Skill;
import com.alex.perspektywy.users.dto.EducationFieldsDTO;
import com.alex.perspektywy.users.dto.SkillsFieldsDTO;

import java.util.List;

public interface ISkillsService {
    List<Skill> getSkillsByFirstLetters(String keyWord);

    SkillsFieldsDTO getSkillsFields();

    EducationFieldsDTO getEducationFields();
}
