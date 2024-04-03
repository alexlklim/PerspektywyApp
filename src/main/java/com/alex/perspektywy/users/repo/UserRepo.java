package com.alex.perspektywy.users.repo;

import com.alex.perspektywy.security.domain.Role;
import com.alex.perspektywy.users.domain.User;
import com.alex.perspektywy.users.domain.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.id  = ?1")
    User getUser(Long id);


    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.isActive = true")
    List<User> getActiveUsers();

    @Query("SELECT u " +
            "FROM User u " +
            "WHERE u.isActive = true AND u.roles = ?1")
    List<User> getActiveUsersByRole(Role role);


    boolean existsByEmail(String email);


    Optional<User> getUserByEmail(String username);



    @Query("SELECT u " +
            "FROM User u " +
            "WHERE :status MEMBER OF u.userStatuses " +
            "ORDER BY u.created DESC")
    List<User> findUsersByStatus(@Param("status") UserStatus status);


}
