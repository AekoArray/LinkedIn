package com.example.demo.service;

import com.example.demo.dto.SkillDto;
import com.example.demo.models.Skill;
import com.example.demo.models.User;

import java.util.ArrayList;
import java.util.List;

public interface SkillService {

    List<SkillDto> getSkillOfUser(User user);

    void save(SkillDto skillDto);
//    List<SkillDto> findSkill(String skill_name);

    String[] getSkills(SkillDto skillDto);

    void saveAll(ArrayList<SkillDto> skills);

    Skill findSkillById(Long id);
}
