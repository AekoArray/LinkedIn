package com.example.demo.service;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.VacancyDto;
import com.example.demo.models.Company;
import com.example.demo.models.Vacancy;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.repositories.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Transactional
    public List<VacancyDto> getAllVacancy() {
        return VacancyDto.from(vacancyRepository.findAll());
    }

    @Override
    public List<VacancyDto> getVacancyOfCompany(Company company) {
        return VacancyDto.from(vacancyRepository.findAllByCompany(company));
    }

    @Override
    public void saveVacancy(VacancyDto vacancyDto, Company company) {
        Vacancy vacancy = Vacancy.builder()
                .name(vacancyDto.getName())
                .description(vacancyDto.getDescription())
                .company(companyRepository.findCompanyByName(company.getName()))
                .build();
        vacancyRepository.save(vacancy);
    }

    @Override
    public List<Vacancy> findVacancy(String vacancyName) {
        List<Vacancy> vacancies = vacancyRepository.findAllByName(vacancyName);
        return vacancies;
    }

}
