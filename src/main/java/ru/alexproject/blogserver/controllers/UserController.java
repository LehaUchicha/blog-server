package ru.alexproject.blogserver.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.User;
import ru.alexproject.blogserver.repositories.UserRepository;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@RequestBody User user) throws ServletException {
//
//        String jwtToken = "";
//
//        if (user.getLogin() == null || user.getPassword() == null) {
//            throw new ServletException("Please fill in username and password");
//        }
//
//        String login = user.getLogin();
//        String password = user.getPassword();
//
//        User requestUser = userRepository.findByUsername(login);
//
//        if (user == null) {
//            throw new ServletException("User email not found.");
//        }
//
//        String pwd = requestUser.getPassword();
//
//        if (!password.equals(pwd)) {
//            throw new ServletException("Invalid login. Please check your name and password.");
//        }
//
//        jwtToken = Jwts.builder().setSubject(login).claim("roles", "user").setIssuedAt(new Date())
//                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
//
//        return jwtToken;
//    }
}
