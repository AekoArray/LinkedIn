package com.example.demo.service;

import com.example.demo.dto.SignUpDto;
import com.example.demo.models.Role;
import com.example.demo.models.State;
import com.example.demo.models.User;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpDto form) {
        User user = User.builder()
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .name(form.getName())
                .education(form.getEducation())
                .state(State.NOT_CONFIRMED)
                .role(Role.USER)
                .createdAt(LocalDateTime.now())
                .build();

        usersRepository.save(user);
    }

}
