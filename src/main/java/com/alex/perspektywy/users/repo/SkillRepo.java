package com.alex.perspektywy.users.repo;

import com.alex.perspektywy.users.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SkillRepo extends JpaRepository<Skill, Long> {


    @Query("SELECT s " +
            "FROM Skill s " +
            "WHERE s.skill = ?1")
    Optional<Skill> findBySkill(String name);
}
