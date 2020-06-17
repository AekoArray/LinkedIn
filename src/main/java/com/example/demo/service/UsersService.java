package com.example.demo.service;

import com.example.demo.dto.SkillDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.User;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();

    void deleteUser(Long userId);

//    List<User> getUserBySkill(String skill);

    User getUserById(Long id);

    List<User> findUsersBySkill(SkillDto skillDto);
}
