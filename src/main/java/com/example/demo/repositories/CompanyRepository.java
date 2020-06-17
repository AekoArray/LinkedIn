package com.example.demo.repositories;

import com.example.demo.models.Company;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByUser(User user);

    List<Company> findAll();

    Company findCompanyByName(String name);

    Company findCompanyById(Long id);

}
