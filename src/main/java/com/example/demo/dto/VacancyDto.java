package com.example.demo.dto;

import com.example.demo.models.Company;
import com.example.demo.models.Vacancy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VacancyDto {
    private String name;
    private String description;
    private Company company;

    public static VacancyDto from(Vacancy vacancy) {
        return VacancyDto.builder()
                .name(vacancy.getName())
                .description(vacancy.getDescription())
                .company(vacancy.getCompany())
                .build();
    }

    public static List<VacancyDto> from(List<Vacancy> company) {
        return company.stream()
                .map(VacancyDto::from)
                .collect(Collectors.toList());
    }
}
