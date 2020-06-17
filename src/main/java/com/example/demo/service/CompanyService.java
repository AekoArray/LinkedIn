package com.example.demo.service;

import com.example.demo.dto.CompanyDto;
import com.example.demo.models.Company;
import com.example.demo.models.User;

import java.util.List;

public interface CompanyService {
        List<CompanyDto> getAllCompany();

        List<CompanyDto> getCompanyOfUser(User user);

        void saveCompany(CompanyDto companyDto, User user);

        Company getCompany(Long id);
}
