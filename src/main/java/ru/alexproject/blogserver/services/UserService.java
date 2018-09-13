package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findUserById(Long id);

    List<UserDto> findAllUsers();

    UserDto findUserByUsername(String username);

    void register(UserDto user);

    void save(UserDto user);
}
