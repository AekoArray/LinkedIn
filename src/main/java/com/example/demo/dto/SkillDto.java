package com.example.demo.dto;

import com.example.demo.models.Assessment;
import com.example.demo.models.Skill;
import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SkillDto {
    private Long id;
    private String skill_name;
    private User user;
//    private int assessmentCounter;
private List<Assessment> assessment;


    public static SkillDto from(Skill skill) {
        return SkillDto.builder()
                .id(skill.getId())
                .skill_name(skill.getSkill_name())
//                .assessmentCounter(skill.getAssessmentCounter())
                .user(skill.getUser())
                .build();
    }

    public static List<SkillDto> from(List<Skill> users) {
        return users.stream()
                .map(SkillDto::from)
                .collect(Collectors.toList());
    }

//    public static Skill to(SkillDto skillDto){
//        return Skill.builder()
//                .skill_name(skillDto.getSkill_name())
//                .build();
//    }
//
//    public static List<Skill> to(List<SkillDto> skillDto){
//        return skillDto
//    }
}
