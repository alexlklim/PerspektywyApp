package com.alex.perspektywy.users.services;

import com.alex.perspektywy.users.domain.Skill;
import com.alex.perspektywy.users.domain.enums.*;

import java.util.List;

public interface ISkillsService {


    void addSkills(List<String> skills);

    Skill getSkillById(Long skillId);

    List<Skill> getSkillsByName(String skillName);


    List<City> getCities();


    List<ExperienceLevel> getExperienceLevels();

    List<ProgrammingLang> getProgrammingLangs();

    List<SpeakingLang> getSpeakingLangs();

    List<UserStatus> getUserStatuses();
}
