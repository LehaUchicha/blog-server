package ru.alexproject.blogserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ru.alexproject.blogserver.model.dto.UserDto;
import ru.alexproject.blogserver.repositories.UserRepository;
import ru.alexproject.blogserver.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto findUserById(Long id) {
        return userRepository.findOne(id).toDto();
    }

    public List<UserDto> findAllUsers() {
        List<UserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(user.toDto()));
        return users;
    }

    @Override
    public UserDto findUserByUsername(String username) {
        return userRepository.findByUsername(username).toDto();
    }

    public void register(UserDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user.toEntity());
    }

    @Override
    public void save(UserDto user) {
        userRepository.save(user.toEntity());
    }
}
