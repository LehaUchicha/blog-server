package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.mapper.Mapper;
import ru.alexproject.blogserver.model.domain.User;
import ru.alexproject.blogserver.model.dto.UserDto;
import ru.alexproject.blogserver.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Users.API_USERS;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Users.REGISTRATION;

@RestController
@RequestMapping(API_USERS)
@CrossOrigin
public class UserController {

    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Mapper modelMapper;

    @Autowired
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder, Mapper modelMapper) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<UserDto> findAllUsers() {
        return userService.findAllUsers().stream()
                .map(user -> modelMapper.convert(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/user/{id}")
    public UserDto findUserById(@PathVariable("id") Long id) {
        return modelMapper.convert(userService.findUserById(id), UserDto.class);
    }

    @PostMapping(value = REGISTRATION)
    public void register(@RequestBody UserDto user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(modelMapper.convert(user, User.class));
    }
}
