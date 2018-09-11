package ru.alexproject.blogserver.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.alexproject.blogserver.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface UserService {

    User findUserById(Long id);

    List<User> findAllUsers();

    User findUserByUsername(String username);

    void register(User user);

    User save(User user);
}
