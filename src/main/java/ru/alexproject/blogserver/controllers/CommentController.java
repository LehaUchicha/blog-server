package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.Comment;
import ru.alexproject.blogserver.repositories.CommentRepository;

import java.util.List;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Comments.API_COMMENTS;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Common.ID;

@RestController
@RequestMapping(API_COMMENTS)
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @GetMapping(value = ID)
    public Comment getPostById(@PathVariable("id") Long id) {
        return commentRepository.findOne(id);
    }

    @PostMapping
    public void createComment(@RequestBody Comment comment) {
        System.out.println("created comment: {}" + comment);
        commentRepository.save(comment);
    }

    @PutMapping(value = ID)
    public void updateComment(@PathVariable("id") Long id, @RequestBody Comment post) {
        Comment comment = commentRepository.findOne(id);
        comment.setAuthor(post.getAuthor());
        comment.setPost(post.getPost());
        comment.setText(post.getText());
        commentRepository.save(comment);
    }

    @DeleteMapping(value = ID)
    public void deleteComment(@PathVariable("id") Long id) {
        commentRepository.delete(id);
    }
}
