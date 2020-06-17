package com.example.demo.controllers;

import com.example.demo.dto.SkillDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@RequestMapping("/users")
//@PreAuthorize("hasAuthority('ADMIN')")
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        List<UserDto> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/users/{user-id}/delete")
    public String deleteUser(@PathVariable("user-id") Long userId) {
        usersService.deleteUser(userId);
        return "redirect:/users";
    }

    @GetMapping("/findUser")
    public String find(){
        return "find_user";
    }

    @PostMapping("/findUser")
    public String findUser(SkillDto skillDto, Model model){
    List<User> users = usersService.findUsersBySkill(skillDto);
    model.addAttribute("users", users);
    return "find_user";
    }
}

