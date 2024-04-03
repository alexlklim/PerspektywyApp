package com.alex.perspektywy.users.services.imp;

import com.alex.perspektywy.users.domain.User;
import com.alex.perspektywy.users.dto.SkillsFieldsDTO;
import com.alex.perspektywy.users.repo.EducationRepo;
import com.alex.perspektywy.users.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SkillsService {

    private final String TAG = "SKILL_SERVICE - ";

    private final UserRepo userRepo;
    private final EducationRepo educationRepo;


    public SkillsFieldsDTO getFieldsForUser(User user) {
        SkillsFieldsDTO skillsFieldsDto = new SkillsFieldsDTO();




        return null;
    }
}
