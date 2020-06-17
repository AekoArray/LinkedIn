package com.example.demo.service;


import com.example.demo.dto.VacancyDto;
import com.example.demo.models.Company;
import com.example.demo.models.Vacancy;

import java.util.List;

public interface VacancyService {
    List<VacancyDto> getAllVacancy();

    List<VacancyDto> getVacancyOfCompany(Company company);

    void saveVacancy(VacancyDto vacancyDto, Company companyName);

    List<Vacancy> findVacancy(String vacancyName);
}
