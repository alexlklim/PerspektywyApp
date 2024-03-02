package com.alex.perspektywy.security.repo;

import com.alex.perspektywy.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

  @Query("SELECT u FROM User u WHERE u.id  = ?1")
  User getUser(Long id);

  @Query("SELECT u FROM User u WHERE u.email  = ?1")
  User getUser(String email);


  boolean existsByEmail(String email);


  Optional<User> getUserByEmail(String username);


}
