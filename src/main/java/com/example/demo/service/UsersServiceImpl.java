package com.example.demo.service;

import com.example.demo.dto.SkillDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.Skill;
import com.example.demo.models.User;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService, UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return UserDto.from(usersRepository.findAll());
    }

    @Override
    public void deleteUser(Long userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public User getUserById(Long id) {
        return usersRepository.findUserById(id);
    }

    @Override
    public List<User> findUsersBySkill(SkillDto skillDto) {
        List<User> users = usersRepository.getUserBySkill_name(skillDto.getSkill_name());
        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return usersRepository.findByName(name);
    }
}

