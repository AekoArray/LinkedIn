package com.example.demo.repositories;


import com.example.demo.dto.SkillDto;
import com.example.demo.models.Skill;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    User findByName(String name);

    User findUserById(Long id);

    List<User> getAllBySkills(Skill skill);

    @Query(value = "select itis_user.* from itis_user join skill on itis_user.id = id_user where skill_name = ?", nativeQuery = true)
    List<User> getUserBySkill_name(String skill_name);

}

