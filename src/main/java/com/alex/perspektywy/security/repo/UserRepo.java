package com.alex.perspektywy.security.repo;

import com.alex.perspektywy.core.domain.Company;
import com.alex.perspektywy.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

  boolean existsByEmail(String email);


  List<User> findByCompany(Company company);


  @Query("SELECT u FROM Member u WHERE u.id  = ?1")
  User getUser(Long id);
}
