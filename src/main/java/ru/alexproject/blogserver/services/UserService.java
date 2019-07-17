package ru.alexproject.blogserver.services;

import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.dto.UserDto;

import java.util.List;

public interface UserService {

    User findUserById(Long id);

    List<User> findAllUsers();

    User findUserByUsername(String username);

    void register(User user);

    void save(User user);
}
