package com.example.demo.controllers;



import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class SignInController {

    @Transactional
    @PreAuthorize("permitAll()")
    @GetMapping("/signIn")
    public String getSignInPage() {
        return "sign_in";
    }

}

