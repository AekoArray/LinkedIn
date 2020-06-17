package com.example.demo.controllers;

import com.example.demo.dto.SkillDto;
import com.example.demo.models.User;
import com.example.demo.repositories.SkillRepository;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.service.SkillService;
import com.example.demo.service.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class SkillController {

    @Autowired
    private SkillService skillService;


    @GetMapping("/skills")
    public String skills(){
        return "skills";
    }

    @PostMapping("/skills")
    public String save(Authentication authentication, SkillDto skillDto){

        System.out.println(skillDto);

        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
        String[] skills = skillService.getSkills(skillDto);

        for (int i = 0; i < skills.length; i++){
            System.out.println(skills[i]);
        }

        ArrayList<SkillDto> skillsDto = new ArrayList<>();
        for (int i = 0; i < skills.length; i++){
            SkillDto skillDto1 = new SkillDto();
            skillDto1.setSkill_name(skills[i]);
            skillDto1.setUser(optionalUser.get());
            skillsDto.add(skillDto1);
        }

        for (int i = 0; i < skillsDto.size(); i++){
            System.out.println(skillsDto.get(i));
            skillService.save(skillsDto.get(i));
        }

        skillService.saveAll(skillsDto);
        return "redirect:/";
    }
}

