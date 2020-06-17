package com.example.demo.repositories;

import com.example.demo.models.Company;
import com.example.demo.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findAll();

    List<Vacancy> findAllByCompany(Company company);

    List<Vacancy> findAllByName(String name);
}
