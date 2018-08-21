package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.User;
import ru.alexproject.blogserver.repositories.UserRepository;

import java.util.List;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Users.API_USERS;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Users.REGISTRATION;

@RestController
@RequestMapping(API_USERS)
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findOne(id);
    }

    @PostMapping(value = REGISTRATION)
    public void register(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
