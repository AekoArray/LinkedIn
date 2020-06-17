package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class SignUpDto {
    private String name;
    @Email(message = "{errors.incorrect.email}")
    private String email;
    @NotNull(message = "{errors.null.password}")
    private String password;
    private String education;
}

