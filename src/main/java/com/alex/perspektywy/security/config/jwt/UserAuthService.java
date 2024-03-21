package com.alex.perspektywy.security.config.jwt;

import com.alex.perspektywy.email.EmailService;

import com.alex.perspektywy.notification.NotificationService;
import com.alex.perspektywy.notification.domain.Reason;
import com.alex.perspektywy.security.UserMapper;
import com.alex.perspektywy.security.domain.User;
import com.alex.perspektywy.security.dto.PasswordDto;
import com.alex.perspektywy.security.dto.RegisterDto;
import com.alex.perspektywy.security.repo.UserRepo;
import com.alex.perspektywy.utils.exceptions.errors.user_error.ObjectAlreadyExistException;
import com.alex.perspektywy.utils.exceptions.errors.user_error.UserNotRegisterYet;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.time.LocalDateTime;
import java.util.Optional;

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

}
