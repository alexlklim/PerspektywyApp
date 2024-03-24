package com.alex.perspektywy.security.controller;

import com.alex.perspektywy.security.config.jwt.AuthenticationService;
import com.alex.perspektywy.security.config.jwt.UserAuthService;
import com.alex.perspektywy.security.dto.*;
import com.alex.perspektywy.utils.SecHolder;
import com.alex.perspektywy.utils.dto.DtoActive;
import com.alex.perspektywy.utils.dto.DtoName;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication Controller", description = "Auth API")
public class AuthController {
    private final String TAG = "AUTHENTICATION_CONTROLLER - ";

    private final UserAuthService userAuthService;
    private final AuthenticationService authenticationService;


    @Operation(summary = "Login user and get Auth DTO")
    @PostMapping("/login")
    public ResponseEntity<AuthDto> authenticate(
            @RequestBody LoginDto loginDto) {
        log.info(TAG + "User authentication");
        return new ResponseEntity<>(
                authenticationService.authenticate(loginDto),
                HttpStatus.OK);
    }

    @Operation(summary = "logout user, inactive refresh token")
    @GetMapping("/logout")
    public ResponseEntity<AuthDto> logout() {
        log.info(TAG + "Log out");
        authenticationService.logout(SecHolder.getPrincipal());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "refresh token and get new Auth DTO")
    @PostMapping("/refresh")
    public ResponseEntity<AuthDto> refreshToken(
            @RequestBody TokenDto tokenDto) {
        log.info(TAG + "Refresh token");
        return new ResponseEntity<>(
                authenticationService.refreshToken(tokenDto),
                HttpStatus.OK);
    }


    @Operation(summary = "change password for authenticated users")
    @PostMapping("/pw/change")
    public ResponseEntity<AuthDto> changePassword(
            @RequestBody PasswordDto passwordDto) {
        log.info(TAG + "Change password for authenticated user");
        userAuthService.changePassword(
                passwordDto,
                SecHolder.getPrincipal());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "send link to email to recovery password")
    @PostMapping("/pw/forgot")
    public ResponseEntity<String> forgotPassword(
            @RequestBody DtoName emailDto) {
        log.info(TAG + "Forgot password, sent link to email");
        authenticationService.forgotPasswordAction(emailDto.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Change password using token and link from email")
    @PostMapping("/pw/recovery/{token}")
    public ResponseEntity<?> recoveryPassword(
            @PathVariable("token") String token,
            @RequestBody DtoName passwordDto) {
        log.info(TAG + "Change password using token and link from email");
        authenticationService.recoveryPassword(token, passwordDto.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Operation(summary = "Register new user")
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(
            @RequestBody RegisterDto registerDto) {
        log.info(TAG + "Register new user");
        userAuthService.register(registerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Operation(summary = "Get info about all user by id (only for admin)")
    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        log.info(TAG + "Get all users");
        return new ResponseEntity<>(
                userAuthService.getAllUsers(),
                HttpStatus.OK);
    }


    @Operation(summary = "Change user visibility (only for admin)")
    @Secured("ROLE_ADMIN")
    @PutMapping("/active")
    public ResponseEntity<HttpStatus> changeUserVisibility(
            @RequestBody DtoActive dtoActive) {
        log.info(TAG + "Try to change user visibility");
        userAuthService.changeUserVisibility(
                dtoActive,
                SecHolder.getUserId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Get info about user by id")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getInfoAboutUser(
            @PathVariable("id") Long userId) {
        log.info(TAG + "Get info about user");
        return new ResponseEntity<>(
                userAuthService.getInfoAboutUserById(userId),
                HttpStatus.OK);
    }



}
