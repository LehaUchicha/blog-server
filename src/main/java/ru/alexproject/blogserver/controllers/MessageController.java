package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.alexproject.blogserver.model.Message;
import ru.alexproject.blogserver.repositories.MessageRepository;

import java.util.List;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Messages.API_MESSAGES;

@RestController
@RequestMapping(API_MESSAGES)
@CrossOrigin
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Message> getdAllMessages(){
//        return messageRepository.findAll();
//    }
}
