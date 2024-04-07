package com.alex.perspektywy.users.controllers;


import com.alex.perspektywy.users.domain.Skill;
import com.alex.perspektywy.users.dto.EducationFieldsDTO;
import com.alex.perspektywy.users.dto.SkillsFieldsDTO;
import com.alex.perspektywy.users.dto.UserDTO;
import com.alex.perspektywy.users.services.imp.SkillsService;
import com.alex.perspektywy.users.services.imp.UserService;
import com.alex.perspektywy.utils.SecHolder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "User Controller", description = "User API")
public class UserController {

    private final String TAG = "COMPANY_CONTROLLER - ";

    private final UserService userService;
    private final SkillsService skillsService;


    @Operation(summary = "Get info about user by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(
            @PathVariable("id") Long userId) {
        log.info(TAG + "Get user by id");
        return userService.getUserById(userId);
    }

    @Operation(summary = "Get users with specific user status")
    @GetMapping("/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getUserById(
            @PathVariable("status") String status) {
        log.info(TAG + "Get user by id");
        return userService.getByUserStatus(status);
    }


    @Operation(summary = "Update user")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(
            @RequestBody Map<String, Object> updates) {
        log.info(TAG + "Update user");
        userService.updateUser(
                SecHolder.getUserId(),
                updates);
    }




    @Operation(summary = "Get skills by first two letter")
    @GetMapping("/skill/{key_word}")
    @ResponseStatus(HttpStatus.OK)
    public List<Skill> getSkillByFirstTwoLetter(
            @PathVariable("key_word") String keyWord) {
        log.info(TAG + "Get skills by first two letter");
        return skillsService.getSkillsByFirstLetters(keyWord);
    }


    @Operation(summary = "Get all possible skills for user")
    @GetMapping("/skills")
    @ResponseStatus(HttpStatus.OK)
    public SkillsFieldsDTO getSkillsForUser() {
        log.info(TAG + "Update user");
        return skillsService.getSkillsFields();
    }

    @Operation(summary = "Get all possible fields for education")
    @GetMapping("/educations")
    @ResponseStatus(HttpStatus.OK)
    public EducationFieldsDTO getFieldsForEducation() {
        log.info(TAG + "Get all possible fields for education");
        return skillsService.getEducationFields();
    }




}
