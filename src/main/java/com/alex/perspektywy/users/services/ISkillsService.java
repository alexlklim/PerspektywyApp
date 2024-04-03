package com.alex.perspektywy.users.services;

import com.alex.perspektywy.users.domain.Skill;
import com.alex.perspektywy.users.domain.enums.*;

import java.util.List;
import java.util.Map;

public interface ISkillsService {

    void updateSkills(List<Map<String, Boolean>> skills, Long userId);

    List<String> getSkills();




    List<Map<String, Object>> getFieldsForUser();
}
