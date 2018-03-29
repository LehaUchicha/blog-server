package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.Comment;
import ru.alexproject.blogserver.repositories.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Comments.API_COMMENTS;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Common.ID;

@RestController
@RequestMapping(API_COMMENTS)
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(value = ID, method = RequestMethod.GET)
    public Comment getPostById(@PathVariable("id") Long id){
        return commentRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createComment(@RequestBody Comment comment){
        System.out.println("created comment: {}" + comment);
        commentRepository.saveAndFlush(comment);
    }

    @RequestMapping(value = ID, method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable("id") Long id){
        commentRepository.delete(id);
    }

    @RequestMapping(value = ID, method = RequestMethod.PUT)
    public void updateComment(@RequestBody Comment post){
        commentRepository.save(post);
    }
}
