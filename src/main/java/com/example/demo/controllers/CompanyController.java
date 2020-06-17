package com.example.demo.controllers;

import com.example.demo.dto.CompanyDto;
import com.example.demo.models.User;
import com.example.demo.service.CompanyService;
import com.example.demo.service.CompanyServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/newCompany")
    public String newCom(){
        return "company";
    }

    @PostMapping("/company")
    public String newCompany(CompanyDto companyDto, Authentication authentication){
        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
        User user = optionalUser.get();
        companyService.saveCompany(companyDto, user);
        return "company";
    }

    @GetMapping("/allCompany")
    public String getCompany(Model model, Authentication authentication){
        Optional<User> optionalUser = (Optional<User>) authentication.getPrincipal();
        List<CompanyDto> companies =  companyService.getCompanyOfUser(optionalUser.get());
        model.addAttribute("companies", companies);
        return "all_company";
    }
}
