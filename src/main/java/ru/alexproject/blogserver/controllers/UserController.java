package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    private Mapper modelMapper;

    private UserDetailsService userDetailsService;

    @Autowired
    public UserController(UserService userService, Mapper modelMapper, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
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
        userService.register(modelMapper.convert(user, User.class));
    }

//    @PostMapping(value = AUTHENTICATE)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto userDto) {
//
//        authenticate(userDto.getUsername(), userDto.getPassword());
//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(userDto.getUsername());
//        final String token = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
//
//
//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
}
