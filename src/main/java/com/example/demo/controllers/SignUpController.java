package com.example.demo.controllers;

import com.example.demo.dto.SignUpDto;
import com.example.demo.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class SignUpController {
    @Autowired
    private SignUpService service;

    @PreAuthorize("permitAll()")
    @GetMapping("/signup")
    public String getSignUpPage(Authentication authentication, Model model) {
        if (authentication == null) {
            model.addAttribute("sForm", new SignUpDto());
            return "sign_up";
        } else {
            return "redirect:/";
        }
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/signup")
    public String signUp( SignUpDto form, Model model) {
        service.signUp(form);
        model.addAttribute("sForm", form);
            return "redirect:/";
    }
}

