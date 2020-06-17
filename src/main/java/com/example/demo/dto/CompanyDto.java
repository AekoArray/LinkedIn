package com.example.demo.dto;

import com.example.demo.models.Company;
import com.example.demo.models.User;
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
public class CompanyDto {
    private Long id;
    private String name;
    private String description;
    private User user;

    public static CompanyDto from(Company company) {
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .user(company.getUser())
                .build();
    }

    public static List<CompanyDto> from(List<Company> users) {
        return users.stream()
                .map(CompanyDto::from)
                .collect(Collectors.toList());
    }
}
