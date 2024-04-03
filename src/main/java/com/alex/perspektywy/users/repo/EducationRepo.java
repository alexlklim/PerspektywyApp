package com.alex.perspektywy.users.repo;

import com.alex.perspektywy.users.domain.Education;
import com.alex.perspektywy.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EducationRepo extends JpaRepository<Education, Long> {

    @Query("SELECT e " +
            "FROM Education e " +
            "WHERE e.user = ?1")
    List<Education> getAllByUser(User user);
}
