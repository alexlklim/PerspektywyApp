package com.alex.perspektywy.users.mappers;

import com.alex.perspektywy.users.domain.Education;
import com.alex.perspektywy.users.domain.Skill;
import com.alex.perspektywy.users.domain.User;
import com.alex.perspektywy.users.dto.EducationDTO;
import com.alex.perspektywy.users.dto.UserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserMapper {


    public static UserDTO toUserDTO(User user, List<Education> educations) {
        return new UserDTO().toBuilder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .abutMe(user.getAboutMe())
                .bornYear(user.getBornYear())
                .longitude(user.getLongitude())
                .latitude(user.getLatitude())
                .experienceLevel(user.getExperienceLevel())
                .city(user.getCity())
                .experienceLevel(user.getExperienceLevel())
                .userStatuses(convertToMapList(user.getUserStatuses()))
                .programmingLangs(convertToMapList(user.getProgrammingLangs()))
                .speakingLangs(convertToMapList(user.getSpeakingLangs()))
                .skills(convertSkillsToMap(user.getSkills()))
                .educations(educations.stream()
                        .map(EducationMapper::toDto)
                        .collect(Collectors.toList()))
                .build();
    }


    private static <E extends Enum<E>> List<Map<String, Boolean>> convertToMapList(List<E> enums) {
        List<Map<String, Boolean>> mapList = new ArrayList<>();
        for (E enumValue : enums) {
            Map<String, Boolean> enumMap = new HashMap<>();
            enumMap.put(enumValue.name(), true);
            mapList.add(enumMap);
        }

        return mapList;
    }


    private static List<Map<String, Boolean>> convertSkillsToMap(List<Skill> skills) {
        List<Map<String, Boolean>> skillMapList = new ArrayList<>();

        for (Skill skill : skills) {
            Map<String, Boolean> skillMap = new HashMap<>();
            skillMap.put(skill.getSkill(), true); // Assuming the user possesses the skill
            skillMapList.add(skillMap);
        }

        return skillMapList;
    }
}
