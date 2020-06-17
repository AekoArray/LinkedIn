package com.example.demo.service;

import com.example.demo.dto.SkillDto;
import com.example.demo.models.Assessment;
import com.example.demo.models.Skill;
import com.example.demo.models.User;
import com.example.demo.repositories.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Override
    public void takeAssessment(User user, Skill skill, User userWhoHaveSkill) {
        Assessment assessment = Assessment.builder()
                .skill(skill)
                .userWhoAssess(user)
                .skillOwner(userWhoHaveSkill)
                .build();
        assessmentRepository.save(assessment);
    }

    @Override
    public Long getCount(Skill skill) {
        Long count = assessmentRepository.countBySkill(skill);
        return count;
    }

    @Override
    public void deleteAssessment(User userWhoAssess, Skill skill, User userOwner) {

        assessmentRepository.delete(assessmentRepository.findAssessmentByUserWhoAssessAndSkillAndSkillOwner(userWhoAssess, skill, userOwner));
    }

    @Override
    public ArrayList<Long> getAssessmentsBySkills(List<SkillDto> skillsDto) {
        System.out.println(skillsDto);
        ArrayList<Skill> skills = new ArrayList<>();
        for (int i = 0; i < skillsDto.size(); i++){
            skills.add(Skill.builder()
            .skill_name(skillsDto.get(i).getSkill_name())
                    .id(skillsDto.get(i).getId())
                    .user(skillsDto.get(i).getUser())
                    .assessment(skillsDto.get(i).getAssessment())
                    .build());

        }
        System.out.println(skills);
        ArrayList<Long> counts = new ArrayList<>();
        for (int i = 0; i < skills.size(); i++){
            Long count = assessmentRepository.countBySkill(skills.get(i));
            counts.add(count);
        }
        return counts;
    }

    @Override
    public Assessment getAssessmentByUserWhoAssessAndSkillAndUserOwner(User userWhoAssess, Skill skill, User userOwner) {
        return assessmentRepository.findAssessmentByUserWhoAssessAndSkillAndSkillOwner(userWhoAssess, skill, userOwner);
    }

}
