package com.example.demo.service;

import com.example.demo.dto.CompanyDto;
import com.example.demo.models.Company;
import com.example.demo.models.User;
import com.example.demo.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<CompanyDto> getAllCompany() {
        return CompanyDto.from(companyRepository.findAll());
    }

    @Override
    public List<CompanyDto> getCompanyOfUser(User user) {
        return CompanyDto.from(companyRepository.findByUser(user));
    }

    @Override
    public void saveCompany(CompanyDto companyDto, User user) {
        Company company = Company.builder()
                .name(companyDto.getName())
                .description(companyDto.getDescription())
                .user(user)
                .build();
        companyRepository.save(company);
    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findCompanyById(id);
    }

}
