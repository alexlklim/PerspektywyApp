package com.alex.perspektywy.security.config.jwt;

import com.alex.perspektywy.email.EmailService;

import com.alex.perspektywy.notification.NotificationService;
import com.alex.perspektywy.notification.domain.Reason;
import com.alex.perspektywy.security.UserMapper;
import com.alex.perspektywy.security.domain.User;
import com.alex.perspektywy.security.dto.PasswordDto;
import com.alex.perspektywy.security.dto.RegisterDto;
import com.alex.perspektywy.security.dto.UserDto;
import com.alex.perspektywy.security.repo.UserRepo;
import com.alex.perspektywy.utils.dto.DtoActive;
import com.alex.perspektywy.utils.exceptions.errors.ResourceNotFoundException;
import com.alex.perspektywy.utils.exceptions.errors.user_error.ObjectAlreadyExistException;
import com.alex.perspektywy.utils.exceptions.errors.user_error.UserNotRegisterYet;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserAuthService {
    private final String TAG = "USER_AUTHENTICATION_SERVICE - ";

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final EmailService emailService;
    private final NotificationService notificationService;


    @SneakyThrows
    public void register(RegisterDto dto) {
        log.info(TAG + "Register user with email: {}", dto.getEmail());
        if (userRepo.existsByEmail(dto.getEmail())) {
            throw new ObjectAlreadyExistException("User with email {} is already exists");
        }
        User user = UserMapper.toUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepo.save(user);
        emailService.accountWasCreated(user);

    }


    @SneakyThrows
    public void changePassword(PasswordDto dto, CustomPrincipal principal) {
        log.info(TAG + "Change password for user with email: {}", principal.getName());
        User user = userRepo.getUser(principal.getUserId());
        if (!passwordEncoder.matches(dto.getCurrentPassword(), user.getPassword()))
            throw new AuthenticationException("Password is wrong");
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepo.save(user);

        notificationService.sendSystemNotificationToSpecificUser(Reason.PASSWORD_WAS_CHANGED, user);
        emailService.passwordWasChanged(principal.getName());
    }


    @SneakyThrows
    public void changePasswordForgot(String email, String password) {
        log.info(TAG + "Change password for user: {}", email);
        User user = userRepo.getUserByEmail(email).orElseThrow(
                () -> new UserNotRegisterYet("User with email " + email + " is not registered"));
        user.setPassword(passwordEncoder.encode(password));
        userRepo.save(user);

        notificationService.sendSystemNotificationToSpecificUser(Reason.PASSWORD_WAS_CHANGED, user);
        emailService.passwordWasChanged(email);
    }


    public User getById(Long userId) {
        log.info(TAG + "Exists by user id: {}", userId);
        return userRepo.findById(userId).orElse(null);
    }

    @Transactional
    public void updateLastActivity(Long userId) {
        User user = userRepo.getUser(userId);
        user.setLastActivity(LocalDateTime.now());
        userRepo.save(user);
    }


    public Optional<User> getUserByEmail(String email) {
        return userRepo.getUserByEmail(email);
    }



    public UserDto getInfoAboutUserById(Long id) {
        return UserMapper.toDto(userRepo.getUser(id));
    }

    public List<UserDto> getAllUsers() {
        log.info(TAG + "Get all users");
        return userRepo.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());

    }


    @SneakyThrows
    @Modifying
    @Transactional
    public void changeUserVisibility(DtoActive dto, Long userId) {
        log.info(TAG + "Change user visibility");
        User user = userRepo.findById(dto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + dto.getId() + " was not found"));
        user.setActive(dto.isActive());
        userRepo.save(user);

        if (dto.isActive()) {
            notificationService.sendSystemNotificationToSpecificUser(Reason.USER_WAS_ENABLED, userRepo.getUser(userId));
            notificationService.sendSystemNotificationToSpecificUser(Reason.YOU_WERE_ENABLED, user);
        }
        notificationService.sendSystemNotificationToSpecificUser(Reason.USER_WAS_DISABLED, userRepo.getUser(userId));
        notificationService.sendSystemNotificationToSpecificUser(Reason.YOU_WERE_DISABLED, user);
    }

}
