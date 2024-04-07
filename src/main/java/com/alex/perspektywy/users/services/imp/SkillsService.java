package com.alex.perspektywy.users.services.imp;

import com.alex.perspektywy.users.domain.Skill;
import com.alex.perspektywy.users.domain.enums.*;
import com.alex.perspektywy.users.dto.EducationFieldsDTO;
import com.alex.perspektywy.users.dto.SkillsFieldsDTO;
import com.alex.perspektywy.users.repo.SkillRepo;
import com.alex.perspektywy.users.services.ISkillsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SkillsService implements ISkillsService {

    private final String TAG = "SKILL_SERVICE - ";

    private final SkillRepo skillRepo;


    @Override
    public List<Skill> getSkillsByFirstLetters(String keyWord) {
        log.info(TAG + "Get skills by first two letter");

        return skillRepo.getByFirstLetters(keyWord);
    }

    @Override
    public SkillsFieldsDTO getSkillsFields() {
        return new SkillsFieldsDTO().toBuilder()
                .cities(City.getAll())
                .userStatuses(UserStatus.getAll())
                .experienceLevels(ExperienceLevel.getAll())
                .programmingLangs(ProgrammingLang.getAll())
                .speakingLangs(SpeakingLang.getAll())
                .build();


    }

    @Override
    public EducationFieldsDTO getEducationFields() {
        log.info(TAG + "Get all possible fields for education");
        return new EducationFieldsDTO().toBuilder()
                .degree(Degree.getAll())
                .specializations(Specialization.getAll())
                .universities(Universities.getAll())
                .build();
    }
}
