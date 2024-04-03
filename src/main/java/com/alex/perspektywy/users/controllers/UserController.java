package com.alex.perspektywy.users.controllers;


import com.alex.perspektywy.users.dto.UserDTO;
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
        log.info(TAG + "Get user by id");
        userService.updateUser(
                SecHolder.getUserId(),
                updates);
    }




}
