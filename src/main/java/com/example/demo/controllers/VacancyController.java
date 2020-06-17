package com.example.demo.controllers;

import com.example.demo.dto.VacancyDto;
import com.example.demo.models.Company;
import com.example.demo.models.Vacancy;
import com.example.demo.service.CompanyService;
import com.example.demo.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VacancyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private VacancyService vacancyService;


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/company/{id}/createNewVacancy")
    public String addVacancy(@PathVariable("id") Long id, Model model){
        Company company = companyService.getCompany(id);
        model.addAttribute("company", company);
        return "new_vacancy";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/company/{id}/createNewVacancy")
    public String addNewVacancy(@PathVariable("id") Long id, @ModelAttribute VacancyDto vacancyDto,  Model model){
        Company company = companyService.getCompany(id);
        vacancyService.saveVacancy(vacancyDto, company);
        return "redirect:/company/{id}/vacancy";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/company/{id}/vacancy")
    public String vacancy(@PathVariable("id") Long id, Model model){
        Company company = companyService.getCompany(id);
        List<VacancyDto> vacancies = vacancyService.getVacancyOfCompany(company);
        model.addAttribute("vacancies", vacancies);
        return "vacancy_of_company";
    }

    @GetMapping("/allVacancy")
    public String getAll(Model model){
        List<VacancyDto> vacancies = vacancyService.getAllVacancy();
        model.addAttribute("vacancies", vacancies);
        return "all_vacancy";
    }

    @GetMapping("/findVacancy")
    public String find(){
        return "find_vacancy";
    }

    @PostMapping("/findVacancy")
    public String findVacancy(VacancyDto vacancyDto, Model model){
        List<Vacancy> vacancies = vacancyService.findVacancy(vacancyDto.getName());
        model.addAttribute("vacancies", vacancies);
        return "find_vacancy";
    }
}
