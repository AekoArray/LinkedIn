package com.example.demo.controllers;

import com.example.demo.dto.SignUpDto;
import com.example.demo.dto.SkillDto;
import com.example.demo.models.Company;
import com.example.demo.models.Skill;
import com.example.demo.models.User;
import com.example.demo.service.AssessmentService;
import com.example.demo.service.SkillService;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private SkillService skillService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private AssessmentService assessmentService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfile(Authentication authentication, Model model) {
        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
        User user = optionalUser.get();
        List<SkillDto> skills = skillService.getSkillOfUser(user);
        model.addAttribute("skills", skills);
        model.addAttribute("user", user);
        return "profile";
    }


    @GetMapping("/user/{id}")
    public String getProfile(@PathVariable("id") Long id, Model model){
        User user = usersService.getUserById(id);
        List<SkillDto> skills = skillService.getSkillOfUser(user);
        ArrayList<Long> counts = assessmentService.getAssessmentsBySkills(skills);
        model.addAttribute("counts", counts);
        model.addAttribute("user", user);
        model.addAttribute("skills", skills);
        return "user_profile";
    }
}

