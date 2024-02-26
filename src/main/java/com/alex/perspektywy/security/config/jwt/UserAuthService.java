package com.alex.perspektywy.security.config.jwt;

import com.alex.perspektywy.security.domain.Role;
import com.alex.perspektywy.security.domain.User;
import com.alex.perspektywy.security.domain.dto.PasswordDto;
import com.alex.perspektywy.security.domain.dto.RegisterDto;
import com.alex.perspektywy.security.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserAuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;


    public boolean register(RegisterDto request) {
        log.info("Try to register user with email: {}", request.getEmail());
        if (userRepo.existsByEmail(request.getEmail())){
            return false;
        }
        try {
            User user = User.builder()
                    .fio("fff")
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .roles(Role.USER)
                    .isEnabled(true)
                    .build();
            userRepo.save(user);
            log.info("User with email {} was successfully created", request.getEmail());

            return true;
        } catch (DataIntegrityViolationException e) {
            log.error("ERROR");
            return false;
        }
    }



    public boolean changePassword(PasswordDto dto, CustomPrincipal principal) {
        log.info("Try to change password for user with email: {}", principal.getName());
        User user = userRepo.findByEmail(principal.getName()).orElse(null);
        assert user != null;
        if (!passwordEncoder.matches(dto.getCurrentPassword(), user.getPassword())) return false;
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepo.save(user);
        return true;
    }


    public void changePasswordForgot(String email, String password) {
        log.info("Change password for user: {}", email);
        User user = userRepo.findByEmail(email).orElse(null);
        if (user == null) return;
        user.setPassword(passwordEncoder.encode(password));
        userRepo.save(user);
    }




    public boolean existsByEmail(String email){
        return userRepo.existsByEmail(email);
    }

    public User getByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }

    public User getById(Long userId) {
        return userRepo.findById(userId).orElse(null);
        }



}
