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
    public void updateComment(@PathVariable("id") Long id, @RequestBody Comment requestComment) {
        Comment comment = commentRepository.findOne(id);
        comment.setPost(requestComment.getPost())
               .setAuthor(requestComment.getAuthor())
               .setText(requestComment.getText());
        commentRepository.save(comment);
    }

    @DeleteMapping(value = ID)
    public void deleteComment(@PathVariable("id") Long id) {
        commentRepository.delete(id);
    }

    public List<Comment> getCommentsByPostId(Long id) {
        return commentRepository.findAll().stream()
                .filter(comment -> id.equals(comment.getPost().getId()))
                .collect(Collectors.toList());
    }
}
