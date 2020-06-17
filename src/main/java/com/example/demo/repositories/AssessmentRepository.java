package com.example.demo.repositories;

import com.example.demo.models.Assessment;
import com.example.demo.models.Skill;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    List<Assessment> findAll();

    long countBySkill(Skill skill);

    Assessment findBySkill(Skill skill);

    List<Assessment> getAssessmentsBySkill(Skill skill);

    Assessment findAssessmentByUserWhoAssessAndSkillAndSkillOwner(User userWhoAssess, Skill skill, User userOwner);

    Assessment findAssessmentById(Long id);
}
