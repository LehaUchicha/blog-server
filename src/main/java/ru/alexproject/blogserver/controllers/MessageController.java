package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.alexproject.blogserver.model.Message;
import ru.alexproject.blogserver.repositories.MessageRepository;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

}
