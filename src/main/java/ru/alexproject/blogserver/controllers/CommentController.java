package ru.alexproject.blogserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alexproject.blogserver.model.dto.CommentDto;
import ru.alexproject.blogserver.services.CommentService;

import java.util.List;

import static ru.alexproject.blogserver.utils.RestApiEndpoints.Comments.API_COMMENTS;
import static ru.alexproject.blogserver.utils.RestApiEndpoints.Common.ID;

@RestController
@RequestMapping(API_COMMENTS)
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentDto> getComments() {
        return commentService.getComments();
    }

    @GetMapping(value = ID)
    public CommentDto getPostById(@PathVariable("id") Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping
    public void createComment(@RequestBody CommentDto comment) {
        commentService.save(comment);
    }

    @PutMapping(value = ID)
    public void updateComment(@PathVariable("id") Long id, @RequestBody CommentDto commentDto) {
        commentService.updateComment(id, commentDto);
    }

    @DeleteMapping(value = ID)
    public void deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
    }

    public List<CommentDto> getCommentsByPostId(Long id) {
        return commentService.getComments();
    }
}
