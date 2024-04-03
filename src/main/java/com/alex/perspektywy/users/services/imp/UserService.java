package com.alex.perspektywy.users.services.imp;

import com.alex.perspektywy.users.domain.Education;
import com.alex.perspektywy.users.domain.Skill;
import com.alex.perspektywy.users.domain.User;
import com.alex.perspektywy.users.domain.enums.*;
import com.alex.perspektywy.users.dto.EducationDTO;
import com.alex.perspektywy.users.dto.UserDTO;
import com.alex.perspektywy.users.mappers.EducationMapper;
import com.alex.perspektywy.users.mappers.UserMapper;
import com.alex.perspektywy.users.repo.EducationRepo;
import com.alex.perspektywy.users.repo.SkillRepo;
import com.alex.perspektywy.users.repo.UserRepo;
import com.alex.perspektywy.utils.exceptions.errors.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final String TAG = "USER_SERVICE - ";

    private final UserRepo userRepo;
    private final SkillRepo skillRepo;
    private final EducationRepo educationRepo;


    @Transactional
    @SneakyThrows
    public UserDTO getUserById(Long userId) {
        log.info(TAG + "Get information about user");
        return UserMapper.toUserDTO(
                userRepo.findById(userId).orElseThrow(
                        () -> new ResourceNotFoundException("User not found with id " + userId)
                ), educationRepo.getAllByUser(userRepo.findById(userId).orElseThrow(
                        () -> new ResourceNotFoundException("User not found with id " + userId)
                ))
        );
    }


    @SneakyThrows
    @Transactional
    public List<UserDTO> getByUserStatus(String status) {
        log.info(TAG + "Get information about user");
        return userRepo.findUsersByStatus(UserStatus.fromString(status))
                .stream()
                .map(user -> UserMapper.toUserDTO(user,
                        educationRepo.getAllByUser(user)))
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @SneakyThrows
    public void updateUser(Long userId, Map<String, Object> updates) {
        log.info(TAG + "Update user");
        User user = userRepo.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id " + userId)
        );
        updates.forEach((key, value) -> {
            switch (key) {
                case "firstname":
                    user.setFirstname((String) value);
                    break;
                case "lastname":
                    user.setLastname((String) value);
                    break;
                case "about_me":
                    user.setAboutMe((String) value);
                    break;
                case "born_year":
                    user.setBornYear((Integer) value);
                    break;
                case "longitude":
                    user.setLongitude((Double) value);
                    break;
                case "latitude":
                    user.setLatitude((Double) value);
                    break;
                case "experience_years":
                    user.setExperienceYears((Integer) value);
                    break;
                case "city":
                    user.setCity(City.fromString((String) value));
                    break;
                case "experience_level":
                    user.setExperienceLevel(ExperienceLevel.fromString((String) value));
                    break;
                case "user_statuses":
                    setUserStatuses(user, (List<Map<String, Boolean>>) value);
                    break;
                case "programming_lang":
                    setProgrammingLang(user, (List<Map<String, Boolean>>) value);
                    break;
                case "speaking_lang":
                    setSpeakingLang(user, (List<Map<String, Boolean>>) value);
                    break;
                case "skills":
                    setSkills(user, (List<Map<String, Boolean>>) value);
                    break;
                case "education":
                    setEducations(user, (List<Map<String, Object>>) value);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
            userRepo.save(user);
        });


    }

    private void setEducations(User user, List<Map<String, Object>> educationDTOList) {
        log.error(educationDTOList.toString());
        for (Map<String, Object> educationMap : educationDTOList) {
            EducationDTO educationDTO = mapToEducationDTO(educationMap);
            Education education = EducationMapper.toEntity(educationDTO);
            education.setUser(user);
            if (educationDTO.getId() != null) {
                education.setId(educationDTO.getId());
            }
            educationRepo.save(education);
        }
    }

    private EducationDTO mapToEducationDTO(Map<String, Object> educationMap) {
        Long id = Long.parseLong(String.valueOf(educationMap.get("id")));
        boolean isActive = (Boolean) educationMap.get("is_active");
        boolean isCurrent = (Boolean) educationMap.get("is_current");
        LocalDate startDate = LocalDate.parse((String) educationMap.get("start_date"));
        LocalDate finishDate = LocalDate.parse((String) educationMap.get("finish_date"));
        String degree = (String) educationMap.get("degree");
        String specialization = (String) educationMap.get("specialization");
        String university = (String) educationMap.get("university");

        return EducationDTO.builder()
                .id(id)
                .isActive(isActive)
                .isCurrent(isCurrent)
                .startDate(startDate)
                .finishDate(finishDate)
                .degree(degree)
                .specialization(specialization)
                .university(university)
                .build();
    }

    private void setSkills(User user, List<Map<String, Boolean>> skills) {
        for (Map<String, Boolean> langMap : skills) {
            if (user.getSkills() == null) user.setSkills(new ArrayList<>());
            for (Map.Entry<String, Boolean> entry : langMap.entrySet()) {
                Skill skill = skillRepo.findBySkill(entry.getKey()).orElse(null);
                if (skill == null && entry.getValue()) {
                    Skill skillNew = new Skill(entry.getKey());
                    Skill skillFromDB = skillRepo.save(skillNew);
                    user.getSkills().add(skillFromDB);
                } else if (skill != null && entry.getValue()) {
                    if (!user.getSkills().contains(skill))
                        user.getSkills().add(skill);
                } else if (skill != null) {
                    user.getSkills().remove(skill);
                }
            }
        }
        userRepo.save(user);
    }

    private void setSpeakingLang(User user, List<Map<String, Boolean>> speakingLangs) {
        for (Map<String, Boolean> langMap : speakingLangs) {
            for (Map.Entry<String, Boolean> entry : langMap.entrySet()) {
                if (entry.getValue()) {
                    try {
                        SpeakingLang speakingLang = SpeakingLang.valueOf(entry.getKey());
                        if (!user.getSpeakingLangs().contains(speakingLang))
                            user.getSpeakingLangs().add(speakingLang);
                    } catch (IllegalArgumentException e) {
                        log.info(TAG + "IllegalArgumentException with SpeakingLang");
                    }
                } else {
                    user.getSpeakingLangs().remove(SpeakingLang.valueOf(entry.getKey()));
                }
            }
        }
        userRepo.save(user);
    }

    private void setProgrammingLang(User user, List<Map<String, Boolean>> programmingLangs) {
        for (Map<String, Boolean> langMap : programmingLangs) {
            for (Map.Entry<String, Boolean> entry : langMap.entrySet()) {
                if (entry.getValue()) {
                    try {
                        ProgrammingLang programmingLang = ProgrammingLang.valueOf(entry.getKey());
                        if (!user.getProgrammingLangs().contains(programmingLang))
                            user.getProgrammingLangs().add(programmingLang);
                    } catch (IllegalArgumentException e) {
                        log.info(TAG + "IllegalArgumentException with ProgrammingLang");
                    }
                } else {
                    user.getProgrammingLangs().remove(ProgrammingLang.valueOf(entry.getKey()));
                }
            }
        }
        userRepo.save(user);
    }

    private void setUserStatuses(User user, List<Map<String, Boolean>> userStatuses) {
        for (Map<String, Boolean> statusMap : userStatuses) {
            for (Map.Entry<String, Boolean> entry : statusMap.entrySet()) {
                if (entry.getValue()) {
                    try {
                        UserStatus status = UserStatus.valueOf(entry.getKey());
                        if (!user.getUserStatuses().contains(status))
                            user.getUserStatuses().add(status);
                    } catch (IllegalArgumentException e) {
                        log.info(TAG + "IllegalArgumentException with UserStatus");
                    }
                } else {
                    user.getUserStatuses().remove(UserStatus.valueOf(entry.getKey()));
                }
            }
        }
        userRepo.save(user);
    }


}
