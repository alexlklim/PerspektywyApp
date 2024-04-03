package com.alex.perspektywy.security.repo;

import com.alex.perspektywy.security.domain.Token;
import com.alex.perspektywy.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TokenRepo extends JpaRepository<Token, Long> {



  void deleteAllByUser(User user);


  Optional<Token> findByUserAndToken(User user, UUID token);

  Optional<Token> findByToken(UUID token);
}
