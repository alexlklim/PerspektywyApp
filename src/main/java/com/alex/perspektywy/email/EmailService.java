package com.alex.perspektywy.email;


import com.alex.perspektywy.security.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Configuration
@RequiredArgsConstructor
public class EmailService {
    private JavaMailSender mailSender;


    public void accountWasCreated(User user) {
        log.info("Send email about creating account to user with email: {}", user.getEmail());

        sendMail("Mail");

    }

    public void forgotPassword(String token, String email) {
        log.info("Send email forgot password to user with email: {}", email);

        sendMail("Mail");
    }

    public void passwordWasChanged(String email) {
        log.info("Send email what password was changed to user with email: {}", email);


        sendMail("Mail");
    }


    @SneakyThrows
    private void sendMail(String mail) {

    }
}