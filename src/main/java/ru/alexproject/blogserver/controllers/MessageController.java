package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.Message;
import ru.alexproject.blogserver.repositories.MessageRepository;

import java.util.List;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Messages.API_MESSAGES;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Messages.MESSAGE_ID;

//@RestController
//@RequestMapping(API_MESSAGES)
//@CrossOrigin
public class MessageController {

    //@Autowired
    private MessageRepository messageRepository;

//    @GetMapping
//    public List<Message> getAllMessages() {
//        return messageRepository.findAll();
//    }
//
//    @GetMapping(value = MESSAGE_ID)
//    public Message getMessageById(@PathVariable("id") Long id) {
//        return messageRepository.getOne(id);
//    }
//
//    @PostMapping
//    public Message createMessage(@RequestBody Message message) {
//        return messageRepository.save(message);
//    }
//
//    @PutMapping(value = MESSAGE_ID)
//    public void updateMessage(@PathVariable("id") Long id, @RequestBody Message message) {
//        Message msg = messageRepository.findOne(id);
//        msg.setText(message.getText());
//        messageRepository.save(msg);
//    }
//
//    @DeleteMapping(value = MESSAGE_ID)
//    public void deleteMessage(@PathVariable("id") Long id) {
//        messageRepository.delete(id);
//    }
}
