package com.example.demo.service;

import com.example.demo.dto.SkillDto;
import com.example.demo.models.Assessment;
import com.example.demo.models.Skill;
import com.example.demo.models.User;

import java.util.ArrayList;
import java.util.List;

public interface AssessmentService {
    void takeAssessment(User user, Skill skill, User userWhoHaveSkill);

    Long getCount(Skill skill);

    void deleteAssessment(User userWhoAssess, Skill skill, User userOwner);

    ArrayList<Long> getAssessmentsBySkills(List<SkillDto> skillsDto);

    Assessment getAssessmentByUserWhoAssessAndSkillAndUserOwner(User userWhoAssess, Skill skill, User userOwner);


}
