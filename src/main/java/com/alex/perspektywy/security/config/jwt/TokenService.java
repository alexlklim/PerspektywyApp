package com.alex.perspektywy.security.config.jwt;

import com.alex.perspektywy.security.domain.Token;
import com.alex.perspektywy.security.domain.User;
import com.alex.perspektywy.security.mapper.DateService;
import com.alex.perspektywy.security.repo.TokenRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Transactional
@Slf4j @RequiredArgsConstructor @Service
public class TokenService {
    private final TokenRepo tokenRepo;

    private final String TAG = "TOKEN SERVICE - ";


    public void deleteTokenByUser(User user) {
        log.info(TAG + "Delete refresh token for user with email: {}", user.getEmail());
        tokenRepo.deleteAllByUser(user);
    }

    public Token getTokenById(Long tokenID){
        log.info(TAG + "Get token by id {}", tokenID);
        return tokenRepo.findById(tokenID).orElse(null);
    }

    public Token createRefreshToken(User user){
        log.info(TAG + "Create refresh token for user with email: {}", user.getEmail());
        tokenRepo.deleteAllByUser(user);
        Token token = new Token();
        token.setUser(user);
        token.setToken(UUID.randomUUID());
        token.setCreated(DateService.getDateNow());
        token.setExpired(DateService.addOneDayToDate(DateService.getDateNow()));
        return tokenRepo.save(token);
    }


    public boolean checkIfTokenValid(UUID refreshToken, User user) {
        log.info(TAG + "Check if token belong to user: {} and not expired", user.getEmail());
        Optional<Token> optionalToken = tokenRepo.findByUserAndToken(user, refreshToken);

        if (optionalToken.isEmpty()) {
            log.error(TAG + "Token {} not exist in DB for user {}", refreshToken, user.getEmail());
            return false;
        }

        // check if token expired
        Token token = optionalToken.get();
        return token.getExpired() != null && token.getExpired().isBefore(LocalDateTime.now());
    }


    public Token getTokenByToken(UUID refreshToken) {
        log.info(TAG + "Get token by token {}", refreshToken);
        return tokenRepo.findByToken(refreshToken);
    }
}
