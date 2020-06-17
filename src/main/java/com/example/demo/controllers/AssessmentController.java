package com.example.demo.controllers;

import com.example.demo.models.Skill;
import com.example.demo.models.User;
import com.example.demo.service.AssessmentService;
import com.example.demo.service.SkillService;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private SkillService skillService;

    @PostMapping("user/{id_user}/skill/{id_skill}/assessment")
    public String giveAssessment(@PathVariable("id_user") Long id_user, @PathVariable("id_skill") Long id_skill, Authentication authentication){
        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
        User user = usersService.getUserById(id_user);
        Skill skill = skillService.findSkillById(id_skill);
        if (assessmentService.getAssessmentByUserWhoAssessAndSkillAndUserOwner(optionalUser.get(), skill, user) == null) {
            assessmentService.takeAssessment(optionalUser.get(), skill, user);
        } else {
            assessmentService.deleteAssessment(optionalUser.get(), skill, user);
        }
        return "redirect:/user/{id_user}";
    }
}
