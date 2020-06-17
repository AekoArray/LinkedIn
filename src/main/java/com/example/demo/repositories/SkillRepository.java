package com.example.demo.repositories;

import com.example.demo.models.Assessment;
import com.example.demo.models.Skill;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByUser(User user);

//    List<Skill> findAllBySkill_name(String skill_name);

    Skill getSkillById(Long id);


}
