package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.dto.UserDto;
import ru.alexproject.blogserver.services.UserService;

import java.util.List;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Users.API_USERS;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Users.REGISTRATION;

@RestController
@RequestMapping(API_USERS)
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public List<UserDto> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/user/{id}")
    public UserDto findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @PostMapping(value = REGISTRATION)
    public void register(@RequestBody UserDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
    }
}
