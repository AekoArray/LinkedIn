package com.example.demo.dto;


import com.example.demo.models.Assessment;
import com.example.demo.models.Skill;
import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AssessmentDto {
    private User skillOwner;
    private Skill skill;
    private User userWhoAssess;

    public static AssessmentDto from(Assessment assessment){
        return AssessmentDto.builder()
                .skillOwner(assessment.getSkillOwner())
                .userWhoAssess(assessment.getUserWhoAssess())
                .skill(assessment.getSkill())
                .build();
    }

    public static List<AssessmentDto> from(List<Assessment> assessments){
        return assessments.stream()
                .map(AssessmentDto::from)
                .collect(Collectors.toList());
    }
}
